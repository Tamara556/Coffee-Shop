package org.example.coffeeshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShopDetailsController {

    @GetMapping("/shop-details")
    public String shopDetailsPage() {
        return "shop-details";
    }

}
