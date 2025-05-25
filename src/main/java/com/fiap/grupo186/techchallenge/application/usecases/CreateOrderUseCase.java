package com.fiap.grupo186.techchallenge.application.usecases;

import com.fiap.grupo186.techchallenge.domains.kitchen.models.Order;
import com.fiap.grupo186.techchallenge.domains.kitchen.services.KitchenService;
import com.fiap.grupo186.techchallenge.application.dtos.PreOrderDTO;
import com.fiap.grupo186.techchallenge.application.ports.OrderRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class CreateOrderUseCase {
    private final OrderRepositoryPort repository;

    private final KitchenService domainService;

    public CreateOrderUseCase(OrderRepositoryPort repository, KitchenService domainService) {
        this.repository = repository;
        this.domainService = domainService;
    }

    public Order execute(PreOrderDTO dto) {
        Order order = dto.makeOrderWithItems();

        domainService.validarRegrasNegocio(order);

        return repository.save(order);
    }
}
