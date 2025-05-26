package com.fiap.grupo186.techchallenge.domains.kitchen.services;

import com.fiap.grupo186.techchallenge.domains.kitchen.models.Order;
import com.fiap.grupo186.techchallenge.domains.kitchen.models.OrderStatus;

public class KitchenService {
    public KitchenService(){
    }
    public boolean isTotalPriceCorrect(Order order) {
        return order.totalPriceValidation();
    }

    public void updateStatusOrder(Order order, OrderStatus status) {
        var currentStatus = order.getStatus();
        if(!currentStatus.canTransitionTo(status)){
            var msg = String.format("Order with current status (%s) cannot be updated to %s",
                currentStatus, status);

            throw new InvalidStatusException(msg);
        }
        order.setStatus(status);
    }
}
