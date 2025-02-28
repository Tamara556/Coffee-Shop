package org.example.coffeeshop.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.coffeeshop.entity.Product;
import org.example.coffeeshop.repository.ProductRepository;
import org.example.coffeeshop.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public List<Product> getProducts() {
        return productRepository.findAll();
    }
}
