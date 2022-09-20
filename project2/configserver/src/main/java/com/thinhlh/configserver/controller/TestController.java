package com.thinhlh.configserver.controller;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Data
public class TestController {

    @GetMapping("/")
    public String getType() {
        return "H";
    }
}
