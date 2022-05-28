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
        return "index";
    }

    @GetMapping("/order")
    public String order(Model model){
        return "order";
    }
}
