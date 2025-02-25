package org.example.coffeeshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @PostMapping("/home")
    public String homePage() {
        return "index";
    }

    @GetMapping("/home")
    public String home() {
        return "index";
    }
}