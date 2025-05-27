package com.fiap.grupo186.techchallenge.domains.kitchen.models;

import java.util.Optional;

public enum OrderStatus {
    PENDING_PAYMENT,
    PAYED,
    RECEIVED,
    IN_PREPARATION,
    READY,
    COMPLETED,
    CANCELED;

    public Optional<OrderStatus> next() {
        return switch (this) {
            case PENDING_PAYMENT -> Optional.of(PAYED);
            case PAYED -> Optional.of(RECEIVED);
            case RECEIVED -> Optional.of(IN_PREPARATION);
            case IN_PREPARATION -> Optional.of(READY);
            case READY -> Optional.of(COMPLETED);
            default -> Optional.empty();
        };
    }

    public boolean canTransitionTo(OrderStatus newStatus) {
        if (newStatus == CANCELED) {
            return this != CANCELED && this != COMPLETED;
        }

        return next().filter(n -> n == newStatus).isPresent();
    }
}
