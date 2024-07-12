package org.school.assignment3.controller;

import org.school.assignment3.model.User;
import org.school.assignment3.service.UserSerivceImpl;
import org.springframework.beans.InvalidPropertyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserSerivceImpl userSerivceImpl;

    @PostMapping("/register")
    public String register(@ModelAttribute User user, Model model) {
        try {
            userSerivceImpl.register(user.getEmail(), user.getPassword());
            model.addAttribute("welcomeMessage", user.getEmail() + "註冊成功！");
            model.addAttribute("username", user.getEmail());
            return "homepage";

        } catch (InvalidPropertyException e) {
            model.addAttribute("registerMessage", "註冊失敗！");
            return "index";
        }
    }

    @PostMapping("/login")
    public String login(User user, Model model) {
        try {
            User loggedUser = userSerivceImpl.login(user.getEmail(), user.getPassword());
            model.addAttribute("welcomeMessage", loggedUser.getEmail() + "登入成功!");
            model.addAttribute("username", loggedUser.getEmail());
            return "homepage";

        } catch (InvalidPropertyException e) {
            model.addAttribute("loginMessage", "登入失敗！");
            return "index";
        }
    }
}



