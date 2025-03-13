package org.example.coffeeshop.mapper;

import org.example.coffeeshop.entity.Product;
import org.example.coffeeshop.request.ProductRequest;
import org.example.coffeeshop.response.ProductResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductResponse toResponse(Product product);
    Product toEntity(ProductRequest productRequest);
}
