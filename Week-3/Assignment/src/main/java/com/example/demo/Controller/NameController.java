package com.example.demo.Controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Controller
public class NameController {
    @GetMapping("/trackName")
    public String setCookie(@RequestParam("name") String inputName, HttpServletResponse response){
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
        Cookie = new Cookie("name", name);
        cookie.setMaxAge(24 * 60 * 60); // One Day.
        response.addCookie(cookie);
        return "redirect:/myName";
    }
    */

    @GetMapping("/myName")
    public String readCookie(@CookieValue(name = "name", required = false) String cookieName,Model model) {
        if (cookieName == null || cookieName.isEmpty()) {
            return "NameForm";
        } else {
            model.addAttribute("cookieName","你的名子是：" + cookieName);
            return "UserName";
        }
    }
}
