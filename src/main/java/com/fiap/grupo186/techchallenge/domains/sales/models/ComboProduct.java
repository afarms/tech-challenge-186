package com.fiap.grupo186.techchallenge.domains.sales.models;

import java.util.UUID;

public record ComboProduct(UUID id, UUID comboId, Product product, int quantity) {

    public Product.Category getCategory() {
        return this.product.category();
    }
}
