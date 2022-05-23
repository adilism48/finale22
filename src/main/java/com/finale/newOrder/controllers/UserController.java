package com.finale.newOrder.controllers;

import com.finale.newOrder.interfaces.UserInterface;
import com.finale.newOrder.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UserController {

    private final UserInterface userInterface;

    public UserController(UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    @GetMapping("/")
    public String main(Model model) {
        Iterable<User> users = userInterface.findAll();
        model.addAttribute("user", users);
        model.addAttribute("title", "main page");
        return "index";
    }
}
