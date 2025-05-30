package com.fiap.grupo186.techchallenge.application.handlers;

import com.fiap.grupo186.techchallenge.application.ports.in.OrderCompletedUseCase;
import com.fiap.grupo186.techchallenge.application.ports.out.CustomerNotification;
import com.fiap.grupo186.techchallenge.application.ports.out.OrderRepositoryPort;
import com.fiap.grupo186.techchallenge.domains.kitchen.models.Order;
import com.fiap.grupo186.techchallenge.domains.kitchen.models.OrderStatus;
import com.fiap.grupo186.techchallenge.domains.kitchen.services.KitchenService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderCompletedHandler implements OrderCompletedUseCase {
    public final OrderRepositoryPort orderRepository;
    public final KitchenService kitchenService;
    public final CustomerNotification notification;

    public OrderCompletedHandler(
        OrderRepositoryPort orderRepository,
        KitchenService kitchenService,
        CustomerNotification notification
    ) {
        this.orderRepository = orderRepository;
        this.kitchenService = kitchenService;
        this.notification = notification;
    }

    @Override
    public Order execute(UUID orderId) {
        var order = orderRepository.findById(orderId);
        kitchenService.updateStatusOrder(order, OrderStatus.COMPLETED);
        var completedOrder = orderRepository.save(order);
        var notificationMessage = kitchenService.messageToNotify(completedOrder);

        notification.notifyCustomer(
            notificationMessage.message(),
            order.getCustomerId()
        );
        return completedOrder;
    }
}
