package com.fiap.grupo186.techchallenge.application.dtos;

import com.fiap.grupo186.techchallenge.domains.kitchen.models.Item;
import com.fiap.grupo186.techchallenge.domains.kitchen.models.Order;
import com.fiap.grupo186.techchallenge.domains.kitchen.models.TypeCombo;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.util.List;

public record PreOrderDTO(
    @NotNull(message = "Order type is required")
    TypeCombo combo,
    @NotNull(message = "Price is required")
    @DecimalMin(value = "1.0", message = "Price must be greater than or equal to 1")
    BigDecimal price,
    @NotNull(message = "Item list must not be null")
    @Size(min = 1, message = "Item list must contain at least one item")
    List<ItemDTO> itemList

) {
    public Order makeOrderWithItems() {
        var order = new Order(
            this.combo,
            this.price
        );
        this.itemList.forEach(item -> {
            var itemToAdd = new Item(
                item.quantity(),
                item.unitPrice(),
                item.customerNote(),
                item.productId(),
                item.productName(),
                item.category()
            );
            order.addItem(itemToAdd);
        });
        return order;
    }
}

