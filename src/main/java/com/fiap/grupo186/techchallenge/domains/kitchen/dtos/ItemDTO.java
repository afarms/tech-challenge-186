package com.fiap.grupo186.techchallenge.domains.kitchen.dtos;

import com.fiap.grupo186.techchallenge.domains.kitchen.Item;
import com.fiap.grupo186.techchallenge.domains.kitchen.Item.Product.ProductCategory;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record ItemDTO(
    @NotNull(message = "Item must not be null")
    @Size(min = 1, message = "Must have at least one item")
    int quantity,
    @NotNull(message = "Category must not be null")
    ProductCategory category,
    @NotNull(message = "Price is required")
    @DecimalMin(value = "1.0", message = "Price must be greater than or equal to 1")
    BigDecimal unitPrice,
    String customerNote,

    @NotNull(message = "Product must not be null")
    ProductDTO product
) {
    public ItemDTO {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }
    }

    public Item.Product makeProductDTO() {
        return new Item.Product(
                product.id(),
                product.name(),
                product.description(),
                product.price(),
                product.isAvailable(),
                product.category(),
                product.createdAt()
        );
    }
}
