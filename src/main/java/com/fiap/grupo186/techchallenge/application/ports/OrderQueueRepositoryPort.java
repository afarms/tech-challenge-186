package com.fiap.grupo186.techchallenge.application.ports;

import com.fiap.grupo186.techchallenge.domains.kitchen.models.Order;

public interface OrderQueueRepositoryPort {
    void queueOrder(Order order);
}
