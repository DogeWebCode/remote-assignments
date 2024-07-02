package com.example.demo.Controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@RestController
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
