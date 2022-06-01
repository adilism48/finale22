package com.finale.newOrder.controllers;

import com.finale.newOrder.interfaces.OrderInterface;
import com.finale.newOrder.interfaces.UserInterface;
import com.finale.newOrder.models.Order;
import com.finale.newOrder.models.User;
import org.springframework.lang.Nullable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class UserController {
    private final OrderInterface orderInterface;
    private final UserInterface userInterface;

    public UserController(OrderInterface orderInterface, UserInterface userInterface) {
        this.orderInterface = orderInterface;
        this.userInterface = userInterface;
    }

    @GetMapping("/")
    public String main(Model model) {
        return "index";
    }

    @GetMapping("/order")
    public String order(Model model) {
        Iterable<User> users = userInterface.findAll();
        Iterable<Order> orders = orderInterface.findAll();
        model.addAttribute("orders", orders);
        model.addAttribute("users", users);
        return "order";
    }

    @PostMapping("/order")
    public String addOrder(@AuthenticationPrincipal User user,
                           @RequestParam("orderStatus") String orderStatus) {
        Order order = new Order(orderStatus, user);

        user.setOrder(order);
        order.setOrderStatus(orderStatus);
        order.setUser(user);
        orderInterface.save(order);
        userInterface.save(user);
        return "redirect:/";
    }
}
