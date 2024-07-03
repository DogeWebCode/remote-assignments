package com.example.demo.Controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Controller
public class nameController {
    @GetMapping("/trackName")
    public String setCookie(@RequestParam("name") String inputName, HttpServletResponse response) throws IOException {
        String encodedName = URLEncoder.encode(inputName, StandardCharsets.UTF_8);
        ResponseCookie resCookie = ResponseCookie.from("name", encodedName)
                .httpOnly(true)
                //one year.
                .maxAge(60 * 60 * 24 * 365)
                .path("/")
                .domain("localhost")
                .build();
        response.addHeader("Set-Cookie", resCookie.toString());
        return "redirect:/myName";
    }

    //practice post
    /*
    @PostMapping("/trackName")
    public String trackName(@RequestParam String name, HttpServletResponse response) {
        Cookie cookie = new Cookie("name", name);
        cookie.setMaxAge(24 * 60 * 60); // 設置 cookie 的有效期為一天
        response.addCookie(cookie);
        return "redirect:/myName";
    }
    */

    @GetMapping("/myName")
    public ResponseEntity<String> readCookie(@CookieValue(name = "name", required = false) String cookieName) {
        if (cookieName == null || cookieName.isEmpty()) {
            return ResponseEntity.ok().body(
                    """
                        <html lang="en">
                        <head>
                            <meta charset="UTF-8">
                            <title>Cookie Demo</title>
                        </head>
                        <body>
                        <h1>Cookie Demo</h1>
                        <form action="/trackName" method="get">
                            <label for="nameInput">Enter your name：</label>
                            <input type="text" name="name" id="nameInput" pattern="[\u4e00-\u9fa5a-zA-Z]+" required>
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
