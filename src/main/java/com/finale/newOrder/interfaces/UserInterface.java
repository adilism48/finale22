package com.finale.newOrder.interfaces;

import com.finale.newOrder.models.Order;
import com.finale.newOrder.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserInterface extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
