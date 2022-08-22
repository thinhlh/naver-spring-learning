package com.thinhlh.hello_world_application.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TemplateController {

    @GetMapping("/greeting")
    public String greeting(Model model) {
        model.addAttribute("name", "Le Hoang Thinh");
        return "greeting";
    }
}
