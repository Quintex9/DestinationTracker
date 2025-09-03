package com.destination.destinations.controller;


import com.destination.destinations.config.AdminProperties;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AdminProperties adminProperties;

    public AuthController(AdminProperties adminProperties) {
        this.adminProperties = adminProperties;
    }

    @PostMapping("/login")
    public boolean login(@RequestBody Map<String, String> payload){
        String username = payload.get("username");
        String password = payload.get("password");

        return adminProperties.getUsername().equals(username)
                && adminProperties.getPassword().equals(password);
    }
}
