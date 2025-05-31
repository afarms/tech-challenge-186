package com.fiap.grupo186.techchallenge.infrastructure.adapters.persistence.entities.sales.mappers;

import com.fiap.grupo186.techchallenge.domains.sales.models.Product;
import com.fiap.grupo186.techchallenge.infrastructure.adapters.persistence.entities.sales.ProductEntity;

public class ProductMapper {

    public static ProductEntity toEntity(Product product) {
        return new ProductEntity(
            product.id(),
            product.name(),
            product.description(),
            product.price(),
            product.category(),
            product.createdAt(),
            product.unavailable(),
            product.available()
        );
    }

    public static Product toDomain(ProductEntity product) {
        return new Product(
            product.getId(),
            product.getName(),
            product.getDescription(),
            product.getPrice(),
            product.getCategory(),
            product.getCreatedAt(),
            product.getUnavailable(),
            product.getAvailable()
        );
    }
}
