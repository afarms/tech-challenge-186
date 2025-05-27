package com.fiap.grupo186.techchallenge.infrastructure.adapters.persistence.repositories;

import com.fiap.grupo186.techchallenge.domains.kitchen.models.Order;
import com.fiap.grupo186.techchallenge.application.ports.OrderRepositoryPort;
import com.fiap.grupo186.techchallenge.domains.kitchen.models.TypeCombo;
import com.fiap.grupo186.techchallenge.infrastructure.adapters.persistence.mappers.OrderMapper;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

@Component
public class OrderRepository implements OrderRepositoryPort {
    @Override
    public Order save(Order order) {
        var orderEntity = OrderMapper.toEntity(order);
        //TODO: Add persistence method and details
        return order;
    }

    @Override
    public Order findById(UUID orderId) {
        //TODO: Add persistence method and details
        //  remove this fake Order when persistence is implemented
        return new Order(
            TypeCombo.CUSTOMIZED,
            BigDecimal.TEN
        );
    }
}
