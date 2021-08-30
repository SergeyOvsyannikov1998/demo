package com.example.demo.controller;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;


@Controller
@RequestMapping("/admin")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/edit/{id}")
    public String editUser(@ModelAttribute("user") User user,Model model, @PathVariable("id") Long id ) {
        model.addAttribute("user", user);
        userService.addUser(user);
        return "redirect:/admin";
    }


    @GetMapping("/user-create")
    public String createUserForm(ModelMap modelMap, Principal principal, Model model) {
        User user = new User();
//        user.setRoles(roleService.findAll());
        model.addAttribute("roles", userService.getUserByName(principal.getName()).getRoles());
        model.addAttribute("user", user);
        modelMap.addAttribute("current_user", userService.getUserByName(principal.getName()));
        return "/main/new";
    }

    @PostMapping("/user-create")
    public String createUser(@ModelAttribute("user") User user) {
        userService.addUser(user);

        return "redirect:/admin/";
    }

    @GetMapping("/remove/{id}")
    public String removeUser(@PathVariable("id") Long id) {
        userService.removeUser(id);
        return "redirect:/admin";
    }
}
