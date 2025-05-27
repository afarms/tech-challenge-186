package com.fiap.grupo186.techchallenge.application.handlers;

import com.fiap.grupo186.techchallenge.application.ports.OrderRepositoryPort;
import com.fiap.grupo186.techchallenge.application.ports.SendOrderToKitchenUseCase;
import com.fiap.grupo186.techchallenge.domains.kitchen.models.OrderStatus;
import com.fiap.grupo186.techchallenge.domains.kitchen.services.KitchenService;

import java.util.UUID;

public class SendOrderToKitchenHandler implements SendOrderToKitchenUseCase {
    OrderRepositoryPort repository;
    KitchenService kitchenService;

    public SendOrderToKitchenHandler(OrderRepositoryPort repository) {
        this.repository = repository;
    }
    @Override
    public void execute(UUID orderId) {
        var order = repository.findById(orderId);

        kitchenService.updateStatusOrder(order, OrderStatus.RECEIVED);
        repository.save(order);

    }
}
