package org.example.coffeeshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogDetalisController {

    @GetMapping("/blog-details")
    public String blogDetailsPage() {
        return "blog-details";
    }

}
