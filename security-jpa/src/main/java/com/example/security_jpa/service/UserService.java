package com.example.security_jpa.service;

import com.example.security_jpa.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    public User findByUsername(String username);
    public User save(User user);
}
