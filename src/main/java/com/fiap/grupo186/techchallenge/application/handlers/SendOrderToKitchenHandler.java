package com.fiap.grupo186.techchallenge.application.handlers;

import com.fiap.grupo186.techchallenge.application.ports.OrderQueueRepositoryPort;
import com.fiap.grupo186.techchallenge.application.ports.OrderRepositoryPort;
import com.fiap.grupo186.techchallenge.application.ports.SendOrderToKitchenUseCase;
import com.fiap.grupo186.techchallenge.domains.kitchen.models.OrderStatus;
import com.fiap.grupo186.techchallenge.domains.kitchen.services.KitchenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SendOrderToKitchenHandler implements SendOrderToKitchenUseCase {
    private static final Logger logger = LoggerFactory.getLogger(SendOrderToKitchenHandler.class);
    private final OrderRepositoryPort repository;
    private final OrderQueueRepositoryPort orderQueueRepository;
    private final KitchenService kitchenService;

    public SendOrderToKitchenHandler(
        OrderRepositoryPort repository,
        KitchenService kitchenService,
        OrderQueueRepositoryPort orderQueueRepository
    ) {
        this.repository = repository;
        this.orderQueueRepository = orderQueueRepository;
        this.kitchenService = kitchenService;
    }
    @Override
    public void execute(UUID orderId) {
        var order = repository.findById(orderId);

        kitchenService.updateStatusOrder(order, OrderStatus.RECEIVED);
        repository.save(order);
        orderQueueRepository.queueOrder(order);
        logger.info("Order ID: {} sent to kitchen", orderId);
    }
}
