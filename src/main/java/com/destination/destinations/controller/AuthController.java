package com.destination.destinations.controller;


import com.destination.destinations.config.AdminProperties;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(
        origins = {"http://localhost:5173", "https://destination-tracker-zyd9.vercel.app"},
        allowedHeaders = "*",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS}
)

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
