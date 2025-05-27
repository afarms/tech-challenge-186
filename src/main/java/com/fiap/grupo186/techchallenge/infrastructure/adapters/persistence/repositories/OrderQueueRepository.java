package com.fiap.grupo186.techchallenge.infrastructure.adapters.persistence.repositories;

import com.fiap.grupo186.techchallenge.application.ports.OrderQueueRepositoryPort;
import com.fiap.grupo186.techchallenge.domains.kitchen.models.Order;
import com.fiap.grupo186.techchallenge.infrastructure.adapters.persistence.mappers.OrderMapper;
import org.springframework.stereotype.Component;

@Component
public class OrderQueueRepository implements OrderQueueRepositoryPort {

    @Override
    public void queueOrder(Order order) {
        var OrderQueue = OrderMapper.toQueue(order);
        //TODO: Add persistence method and details
    }
}
