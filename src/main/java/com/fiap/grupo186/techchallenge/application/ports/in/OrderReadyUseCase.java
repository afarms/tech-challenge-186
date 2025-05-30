package com.fiap.grupo186.techchallenge.application.ports.in;

import com.fiap.grupo186.techchallenge.domains.kitchen.models.Order;

import java.util.UUID;

public interface OrderReadyUseCase {
    Order execute(UUID orderID);
}
