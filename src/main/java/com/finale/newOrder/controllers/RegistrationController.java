package com.finale.newOrder.controllers;

import com.finale.newOrder.interfaces.UserInterface;
import com.finale.newOrder.models.Role;
import com.finale.newOrder.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private UserInterface userInterface;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }
    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model) {
        User UsernameFromDb = userInterface.findByUsername(user.getUsername());

        if (UsernameFromDb != null) {
            model.put("message1", "User exists!");
            return "registration";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userInterface.save(user);

        return "redirect:/login";
    }
}
