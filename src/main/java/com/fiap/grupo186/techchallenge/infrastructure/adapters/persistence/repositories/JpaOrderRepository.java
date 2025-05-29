package com.fiap.grupo186.techchallenge.infrastructure.adapters.persistence.repositories;

import com.fiap.grupo186.techchallenge.domains.kitchen.models.Order;
import com.fiap.grupo186.techchallenge.application.ports.out.OrderRepositoryPort;
import com.fiap.grupo186.techchallenge.domains.kitchen.models.TypeCombo;
import com.fiap.grupo186.techchallenge.infrastructure.adapters.persistence.mappers.OrderMapper;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Component
public class JpaOrderRepository implements OrderRepositoryPort {
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
            BigDecimal.TEN,
            UUID.randomUUID(),
            "Dummy name"
        );
    }

    @Override
    public List<Order> findAllById(List<UUID> ids) {
        //TODO: Add persistence method and details
        //  remove this fake OrderList when persistence is implemented
        return List.of(
            new Order(
                TypeCombo.CUSTOMIZED,
                BigDecimal.TEN,
                UUID.randomUUID(),
                "Dummy name"
            ),
            new Order(
                TypeCombo.CUSTOMIZED,
                BigDecimal.TEN,
                UUID.randomUUID(),
                "Dummy name"
            )
        );
    }
}
