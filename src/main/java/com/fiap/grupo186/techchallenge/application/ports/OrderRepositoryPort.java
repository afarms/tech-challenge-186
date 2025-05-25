package com.fiap.grupo186.techchallenge.application.ports;

import com.fiap.grupo186.techchallenge.domains.kitchen.models.Order;

public interface OrderRepositoryPort {
    Order save(Order order);
}
