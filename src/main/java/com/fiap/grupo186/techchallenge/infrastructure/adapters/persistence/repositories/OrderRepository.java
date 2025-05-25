package com.fiap.grupo186.techchallenge.infrastructure.adapters.persistence.repositories;

import com.fiap.grupo186.techchallenge.domains.kitchen.models.Order;
import com.fiap.grupo186.techchallenge.application.ports.OrderRepositoryPort;
import org.springframework.stereotype.Component;

@Component
public class OrderRepository implements OrderRepositoryPort {
    @Override
    public Order save(Order order) {
        System.out.println("Saving order: " + order);
        //TODO: Add persistence logic and details
        return order;
    }
}
