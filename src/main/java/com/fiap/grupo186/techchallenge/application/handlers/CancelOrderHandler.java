package com.fiap.grupo186.techchallenge.application.handlers;

import com.fiap.grupo186.techchallenge.application.ports.in.CancelOrderUseCase;
import com.fiap.grupo186.techchallenge.application.ports.out.OrderRepositoryPort;
import com.fiap.grupo186.techchallenge.domains.kitchen.models.Order;
import com.fiap.grupo186.techchallenge.domains.kitchen.models.OrderStatus;
import com.fiap.grupo186.techchallenge.domains.kitchen.services.KitchenService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CancelOrderHandler implements CancelOrderUseCase {
    private final OrderRepositoryPort orderRepository;
    private final KitchenService kitchenService;

    public CancelOrderHandler(OrderRepositoryPort orderRepository, KitchenService kitchenService) {
        this.orderRepository = orderRepository;
        this.kitchenService = kitchenService;
    }

    @Override
    public Order execute(UUID orderId) {
        var order = orderRepository.findById(orderId);
        kitchenService.updateStatusOrder(order, OrderStatus.CANCELED);
        return orderRepository.save(order);
    }
}
