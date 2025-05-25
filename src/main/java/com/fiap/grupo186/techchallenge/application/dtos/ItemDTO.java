package com.fiap.grupo186.techchallenge.application.dtos;

import com.fiap.grupo186.techchallenge.domains.kitchen.models.Item;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.util.UUID;

public record ItemDTO(
    @NotNull(message = "Item must not be null")
    @Size(min = 1, message = "Must have at least one item")
    int quantity,
    @NotNull(message = "Category must not be null")
    Item.ProductCategory category,
    @NotNull(message = "Price is required")
    @DecimalMin(value = "1.0", message = "Price must be greater than or equal to 1")
    BigDecimal unitPrice,
    @NotNull(message = "ProductID not be null")
    UUID productId,
    String customerNote,
    @NotNull(message = "Product name must not be null")
    String productName
) {}

