package com.fiap.grupo186.techchallenge.application.usecases;

import com.fiap.grupo186.techchallenge.application.ports.OrderRepositoryPort;
import com.fiap.grupo186.techchallenge.application.ports.UpdateStatusOrderPort;
import com.fiap.grupo186.techchallenge.domains.kitchen.models.OrderStatus;
import com.fiap.grupo186.techchallenge.domains.kitchen.services.KitchenService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UpdateStatusOrderUseCase implements UpdateStatusOrderPort {
    private final OrderRepositoryPort repository;
    private final KitchenService service;

    public UpdateStatusOrderUseCase(OrderRepositoryPort repository, KitchenService service) {
        this.repository = repository;
        this.service = service;
    }

    @Override
    public void execute(UUID orderId, OrderStatus status){
        var order = repository.findById(orderId);
        service.updateStatusOrder(order, status);
        repository.save(order);
    }
}
