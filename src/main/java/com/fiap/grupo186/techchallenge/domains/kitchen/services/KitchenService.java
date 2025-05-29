package com.fiap.grupo186.techchallenge.domains.kitchen.services;

import com.fiap.grupo186.techchallenge.domains.kitchen.models.Notification;
import com.fiap.grupo186.techchallenge.domains.kitchen.models.Order;
import com.fiap.grupo186.techchallenge.domains.kitchen.models.OrderStatus;

public class KitchenService {
    public KitchenService(){
    }
    public boolean isTotalPriceCorrect(Order order) {
        return order.totalPriceValidation();
    }

    public void updateStatusOrder(Order order, OrderStatus status) throws InvalidStatusException {
        var currentStatus = order.getStatus();
        if(!currentStatus.canTransitionTo(status)){
            var msg = String.format("Order with current status (%s) cannot be updated to %s",
                currentStatus, status);

            throw new InvalidStatusException(msg);
        }
        order.setStatus(status);
    }

    public Notification messageToNotify(Order order) {
        return new Notification(
            order.getCustomerName().isEmpty() ? "Caro cliente" : order.getCustomerName(),
            String.format("Seu pedido de ID %s está pronto!", order.getId()),
            order.getId().toString()
        );
    }
}
