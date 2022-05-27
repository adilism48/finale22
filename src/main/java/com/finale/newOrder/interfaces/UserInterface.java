package com.finale.newOrder.interfaces;

import com.finale.newOrder.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInterface extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
