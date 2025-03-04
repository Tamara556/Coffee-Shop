package org.example.coffeeshop.controller;

import lombok.RequiredArgsConstructor;
import org.example.coffeeshop.mapper.ProductMapper;
import org.example.coffeeshop.response.ProductResponse;
import org.example.coffeeshop.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/menu")
@RequiredArgsConstructor
public class MenuController {
    private final ProductService productService;
    private final ProductMapper productMapper;

    @GetMapping
    public String showMenu(Model model) {
        List<ProductResponse> products = productService.getProducts()
                .stream()
                .map(productMapper::toResponse)
                .toList();
        model.addAttribute("products", products);
        return "menu";
    }
}
