package com.thinhlh.btvn31.config.resources;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "message")
@Component
@Data
public class Messages {
    private String duplicatedName;
}
