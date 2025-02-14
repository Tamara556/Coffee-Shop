package org.example.coffeeshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SingleServiceController {

    @GetMapping("/single-service")
    public String singleServicePage() {
        return "single-service";
    }

}
