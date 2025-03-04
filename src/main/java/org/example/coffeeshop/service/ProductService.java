package org.example.coffeeshop.service;

import org.example.coffeeshop.entity.Product;
import org.example.coffeeshop.response.ProductResponse;

import java.util.List;

public interface ProductService {
    List<Product> getProducts();
}
