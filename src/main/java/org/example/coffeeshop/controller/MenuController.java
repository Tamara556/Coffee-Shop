package org.example.coffeeshop.controller;

import org.example.coffeeshop.entity.Product;
import org.example.coffeeshop.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MenuController {
    private final ProductService productService;

    public MenuController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/menu")
    public String menuPage(Model model) {
        List<Product> products = productService.getProducts();
        model.addAttribute("products", products);
        return "menu";
    }
}