package com.example.demo.Controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseCookie;
import org.springframework.web.bind.annotation.CookieValue;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;


@RestController
public class Controller {
    @RequestMapping(value = "/data", method = RequestMethod.GET)
    public String numberSum(@RequestParam(value = "num", required = true, defaultValue = "") String num) {
        //中括號用於定義character class，\d是代表0~9，*代表0或多個數字。
        boolean isInteger = num.matches("^[\\d]*$");
        if (num.isEmpty()) {
            return "Lack of Parameter";
        } else if (!isInteger) {
            return "Wrong Parameter";
        } else {
            try {
                // 用long type擴大數字範圍，盡量避免溢位情況發生。
                long number = Long.parseLong(num);
                // (1 + 2 + 3 +...+ N) = N * (N + 1) / 2 => 求和公式
                // 此公式只會跑一次乘法、一次加法、一次除法，與n無關，時間複雜度為O(1)，用nanotime看都是200ns左右。
                long total = number * (number + 1) / 2;

                /* 若使用for迴圈計算，時間複雜度為O(n)，n越大，算的次數也會越多，用nanotime看每多一位數大概增加10倍的時間。
                for (int i = 0; i <= number; i++) {
                    total1 += i;
                }
                */
                return (String.valueOf(total));
            } catch (NumberFormatException e) {
                return "Too Large Number";
            }
        }
    }

    @GetMapping("/trackName")
    public String setCookie(@RequestParam("name") String inputName, HttpServletResponse response) throws IOException {
        String encodedName = URLEncoder.encode(inputName, StandardCharsets.UTF_8);
        ResponseCookie resCookie = ResponseCookie.from("name", encodedName)
                .httpOnly(true)
                .maxAge(60 * 60 * 24 * 365)
                .path("/")
                .domain("localhost")
                .build();
        response.addHeader("Set-Cookie", resCookie.toString());
        response.sendRedirect("/myName");
        return "cookie set";
    }

    @GetMapping("/myName")
    public ResponseEntity<String> readCookie(@CookieValue(name = "name", required = false) String cookieName) {
        if (cookieName == null) {
            return ResponseEntity.ok().body(
                """
                    <html lang="en">
                    <head>
                        <meta charset="UTF-8">
                        <title>Cookie Demo</title>
                    </head>
                    <body>
                    <h1>Cookie Demo</h1>
                    <form action="/trackName">
                        <label for="nameInput">Enter your name：</label>
                        <input type="text" name="name" id="nameInput" required>
                        <input type="submit" value="submit" id="submitBtn">
                    </form>
                    </body>
                    </html>
                """
            );
        } else {
            return ResponseEntity.ok().body("Your name is: " + cookieName);
        }
    }
}

