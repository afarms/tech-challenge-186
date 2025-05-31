package com.fiap.grupo186.techchallenge.infrastructure.adapters.persistence.repositories;

import com.fiap.grupo186.techchallenge.application.ports.out.OrderQueueRepositoryPort;
import com.fiap.grupo186.techchallenge.domains.kitchen.models.Order;
import com.fiap.grupo186.techchallenge.infrastructure.adapters.persistence.mappers.OrderMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class JpaOrderQueueRepository implements OrderQueueRepositoryPort {

    @Override
    public void queueOrder(Order order) {
        var OrderQueue = OrderMapper.toQueue(order);
        //TODO: Add persistence method and details
    }

    @Override
    public List<Order> nextOrdersForPreparation(int numberOfOrders) {
        return null;
    }
}
