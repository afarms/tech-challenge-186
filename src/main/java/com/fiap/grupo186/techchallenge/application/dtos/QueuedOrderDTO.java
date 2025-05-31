package com.fiap.grupo186.techchallenge.application.dtos;

import com.fiap.grupo186.techchallenge.domains.kitchen.models.OrderStatus;

import java.time.LocalDateTime;

public record QueuedOrderDTO(
    String orderId,
    String customerName,
    String orderDetails,

    String typeCombo,
    OrderStatus status,
    LocalDateTime queuedTime
) {
}
