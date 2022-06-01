package com.finale.newOrder.service;

import com.finale.newOrder.interfaces.UserInterface;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    private final UserInterface userInterface;

    public UserService(UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userInterface.findByUsername(username);
    }
}
