package com.fiap.grupo186.techchallenge.application.dtos;

import com.fiap.grupo186.techchallenge.domains.kitchen.models.Item.Product.ProductCategory;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record ProductDTO(
        UUID id,
        String name,
        String description,
        BigDecimal price,
        ProductCategory category,
        LocalDateTime createdAt,
        boolean isAvailable
) {
}
