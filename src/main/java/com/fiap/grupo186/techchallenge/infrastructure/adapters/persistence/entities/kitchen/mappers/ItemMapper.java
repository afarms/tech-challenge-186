package com.fiap.grupo186.techchallenge.infrastructure.adapters.persistence.entities.kitchen.mappers;

import com.fiap.grupo186.techchallenge.domains.kitchen.models.Item;
import com.fiap.grupo186.techchallenge.infrastructure.adapters.persistence.entities.kitchen.ItemEntity;
import com.fiap.grupo186.techchallenge.infrastructure.adapters.persistence.entities.kitchen.OrderEntity;

public class ItemMapper {
    public static ItemEntity toEntity(Item item, OrderEntity orderEntity) {
        return new ItemEntity(
            item.getId(),
            orderEntity,
            item.getQuantity(),
            item.getUnitPrice(),
            item.getCustomerNote(),
            item.getProductId(),
            item.getProductName(),
            item.getProductCategory(),
            item.getCreatedAt()
        );
    }
}
