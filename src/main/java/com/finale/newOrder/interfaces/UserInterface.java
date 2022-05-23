package com.finale.newOrder.interfaces;

import com.finale.newOrder.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserInterface extends CrudRepository<User, Long> {
}
