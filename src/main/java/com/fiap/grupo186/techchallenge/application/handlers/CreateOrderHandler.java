package com.fiap.grupo186.techchallenge.application.handlers;

import com.fiap.grupo186.techchallenge.application.ports.CreatOrderUseCase;
import com.fiap.grupo186.techchallenge.domains.kitchen.models.Order;
import com.fiap.grupo186.techchallenge.domains.kitchen.services.KitchenService;
import com.fiap.grupo186.techchallenge.application.dtos.PreOrderDTO;
import com.fiap.grupo186.techchallenge.application.ports.OrderRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class CreateOrderHandler implements CreatOrderUseCase {
    private final OrderRepositoryPort repository;

    private final KitchenService domainService;

    public CreateOrderHandler(OrderRepositoryPort repository, KitchenService domainService) {
        this.repository = repository;
        this.domainService = domainService;
    }

    @Override
    public Order execute(PreOrderDTO dto) {
        Order order = dto.makeOrderWithItems();
        if (!domainService.isTotalPriceCorrect(order)) {
            throw new IllegalArgumentException("Order total price is invalid!");
        }
        // Once the order has been validated, the customer must make the payment.
        return repository.save(order);
    }
}
