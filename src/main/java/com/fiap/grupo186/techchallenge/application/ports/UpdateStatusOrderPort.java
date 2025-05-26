package com.fiap.grupo186.techchallenge.application.ports;

import com.fiap.grupo186.techchallenge.domains.kitchen.models.OrderStatus;

import java.util.UUID;

public interface UpdateStatusOrderPort {
    void execute(UUID orderId, OrderStatus status);
}
