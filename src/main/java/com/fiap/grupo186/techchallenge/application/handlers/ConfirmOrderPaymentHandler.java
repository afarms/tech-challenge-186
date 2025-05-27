package com.fiap.grupo186.techchallenge.application.handlers;

import com.fiap.grupo186.techchallenge.application.ports.OrderRepositoryPort;
import com.fiap.grupo186.techchallenge.application.ports.ConfirmOrderPaymentUseCase;
import com.fiap.grupo186.techchallenge.domains.kitchen.models.OrderStatus;
import com.fiap.grupo186.techchallenge.domains.kitchen.services.KitchenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class ConfirmOrderPaymentHandler implements ConfirmOrderPaymentUseCase {

    private static final Logger logger = LoggerFactory.getLogger(ConfirmOrderPaymentHandler.class);
    private final OrderRepositoryPort repository;
    private final KitchenService service;

    public ConfirmOrderPaymentHandler(OrderRepositoryPort repository, KitchenService service) {
        this.repository = repository;
        this.service = service;
    }

    @Override
    public void execute(UUID orderId){
        var order = repository.findById(orderId);
        service.updateStatusOrder(order, OrderStatus.PAYED);
        order.setPaidAt(LocalDateTime.now());
        repository.save(order);
        logger.info("Successful payment for Order ID: {}", orderId);
    }
}
