package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;


import java.security.Principal;
import java.util.List;

@Controller
public class HelloController {
    @Autowired
    private UserService userService;

    public HelloController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "admin")
    public String welcome(Principal principal, ModelMap model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("user", userService.getUserByName(principal.getName()));
        model.addAttribute("roles", userService.getUserByName(principal.getName()).getRoles());
        model.addAttribute("users", users);

        return "main/index";
    }
    @GetMapping(value = "user")
    public String welcomeUs(Principal principal, ModelMap model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("user", userService.getUserByName(principal.getName()));
        model.addAttribute("users", users);
        return "user/user";
    }
    @GetMapping(value = "login")
    public String loginPage() {

        return "login";
    }
    @GetMapping(value = "/")
    public String first(Principal principal, Model model) {

        model.addAttribute("user", userService.getUserByName(principal.getName()));
        return "main/index";
    }
}
