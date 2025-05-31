package com.fiap.grupo186.techchallenge.application.handlers.kitchen;

import com.fiap.grupo186.techchallenge.application.ports.in.kitchen.OrderReadyUseCase;
import com.fiap.grupo186.techchallenge.application.ports.out.OrderRepositoryPort;
import com.fiap.grupo186.techchallenge.domains.kitchen.models.Order;
import com.fiap.grupo186.techchallenge.domains.kitchen.models.OrderStatus;
import com.fiap.grupo186.techchallenge.domains.kitchen.services.KitchenService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderReadyHandler implements OrderReadyUseCase {
    private final OrderRepositoryPort orderRepository;
    private final KitchenService kitchenService;

    public OrderReadyHandler(
        OrderRepositoryPort orderRepository,
        KitchenService kitchenService
    ) {
        this.orderRepository = orderRepository;
        this.kitchenService = kitchenService;
    }

    @Override
    public Order execute(UUID orderId) {
       var order = orderRepository.findById(orderId);
       kitchenService.updateStatusOrder(order, OrderStatus.READY);
        return orderRepository.save(order);
    }
}
