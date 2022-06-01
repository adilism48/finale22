package com.finale.newOrder.interfaces;

import com.finale.newOrder.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderInterface extends JpaRepository<Order, Long> {

}
