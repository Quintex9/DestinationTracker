package com.destination.destinations.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "admin")
public class AdminProperties {
    @Getter
    @Setter
    private String username;
    @Getter
    @Setter
    private String password;

}
