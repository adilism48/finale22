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
    public String order(@AuthenticationPrincipal User user,
                        Model model) {
        Iterable<User> users = userInterface.findAll();
        Iterable<Order> orders = orderInterface.findAll();
        String username = user.getUsername();

        model.addAttribute("orders", orders);
        model.addAttribute("users", users);
        model.addAttribute("orderStatus", username);
        return "order";
    }

    @PostMapping("/order")
    public String addOrder(@AuthenticationPrincipal User user,
                           @RequestParam(value = "orderStatus", required = false) String orderStatus,
                           Model model) {

        Order order = new Order(orderStatus, user);
        Order orderStatFromDb = orderInterface.findByOrderStatus(order.getOrderStatus());

        if(orderStatFromDb != null) {
            model.addAttribute("orderStatusMsg", "You have already ordered");
            return "order";
        }

        order.setOrderStatus(orderStatus);
        order.setUser(user);
        orderInterface.save(order);
        userInterface.save(user);
        return "redirect:/order";
    }
}
