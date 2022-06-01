package com.finale.newOrder.interfaces;

import com.finale.newOrder.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface OrderInterface extends JpaRepository<Order, Long> {
    Order findByOrderStatus(String orderStatus);
}
