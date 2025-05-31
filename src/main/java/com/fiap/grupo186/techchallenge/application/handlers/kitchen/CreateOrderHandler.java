package com.fiap.grupo186.techchallenge.application.handlers.kitchen;

import com.fiap.grupo186.techchallenge.application.ports.in.kitchen.CreatOrderUseCase;
import com.fiap.grupo186.techchallenge.domains.kitchen.models.Order;
import com.fiap.grupo186.techchallenge.domains.kitchen.services.KitchenService;
import com.fiap.grupo186.techchallenge.application.dtos.PreOrderDTO;
import com.fiap.grupo186.techchallenge.application.ports.out.OrderRepositoryPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CreateOrderHandler implements CreatOrderUseCase {
    private static final Logger logger = LoggerFactory.getLogger(CreateOrderHandler.class);
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
            var msg = String.format("Order total price is invalid! order id: %s", order.getId());
            logger.warn(msg);
            throw new IllegalArgumentException(msg);
        }
        // Once the order has been validated, the customer must make the payment.
        var orderUpdated = repository.save(order);
        logger.info("Order created with ID: {}", orderUpdated.getId());
        return orderUpdated;
    }
}
