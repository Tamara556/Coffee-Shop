package org.example.coffeeshop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.coffeeshop.entity.Category;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {
    private int id;
    private String name;
    private String description;
    private double price;
    private Category category;
    private String image;
}
