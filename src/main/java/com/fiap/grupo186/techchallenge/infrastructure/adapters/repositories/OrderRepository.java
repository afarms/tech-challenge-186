package com.fiap.grupo186.techchallenge.infrastructure.adapters.repositories;

import com.fiap.grupo186.techchallenge.domains.kitchen.Order;
import com.fiap.grupo186.techchallenge.domains.kitchen.ports.repositories.OrderRepositoryPort;
import org.springframework.stereotype.Component;

@Component
public class OrderRepository implements OrderRepositoryPort {
    @Override
    public void save(Order order) {
        System.out.println("Saving order: " + order);
        //TODO: Add persistence logic and details
    }
}
