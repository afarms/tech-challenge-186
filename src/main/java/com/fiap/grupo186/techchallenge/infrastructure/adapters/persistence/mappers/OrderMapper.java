package com.fiap.grupo186.techchallenge.infrastructure.adapters.persistence.mappers;

import com.fiap.grupo186.techchallenge.domains.kitchen.models.Order;
import com.fiap.grupo186.techchallenge.infrastructure.adapters.persistence.entities.OrderEntity;

public class OrderMapper {
    public static OrderEntity toEntity(Order order) {
        OrderEntity orderEntity = new OrderEntity();
        var itemEntityList = order.getItemList().stream()
            .map(item -> ItemMapper.toEntity(item, orderEntity))
            .toList();

        orderEntity.setId(order.getId());
        orderEntity.setPrice(order.getPrice());
        orderEntity.setStatus(order.getStatus());
        orderEntity.setCombo(order.getCombo());
        orderEntity.setCreatedAt(order.getCreatedAt());
        orderEntity.setCompletedAt(order.getCompletedAt());
        orderEntity.setItemList(itemEntityList);
        orderEntity.setPaidAt(order.getPaidAt());

        return orderEntity;
    }
}
