package com.fiap.grupo186.techchallenge.domains.kitchen.ports.repositories;

import com.fiap.grupo186.techchallenge.domains.kitchen.Order;

public interface OrderRepositoryPort {
    void save(Order order);
}
