package org.example.coffeeshop.repository;

import org.example.coffeeshop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}