package org.school.assignment3.controller;

import org.school.assignment3.model.UserRequest;
import org.school.assignment3.service.UserSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/api/db")
public class UserController {
    @Autowired
    private UserSerivce userSerivce;

    @GetMapping("/test")
    @ResponseBody
    public ArrayList<String> getUser() {
        return userSerivce.getAll();
    }

    @PostMapping("/test2")
    public String createUser(@RequestBody UserRequest userRequest) {
        userSerivce.createUser(userRequest.getEmail(), userRequest.getPassword());
        return null;
    }
}



