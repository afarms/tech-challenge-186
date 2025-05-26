package com.fiap.grupo186.techchallenge.domains.kitchen.models;

import java.util.Optional;

public enum OrderStatus {
    DRAFT,
    PENDING,
    QUEUED,
    IN_PROGRESS,
    COMPLETED,
    FINISHED,
    CANCELED;

    public Optional<OrderStatus> next() {
        return switch (this) {
            case DRAFT -> Optional.of(PENDING);
            case PENDING -> Optional.of(QUEUED);
            case QUEUED -> Optional.of(IN_PROGRESS);
            case IN_PROGRESS -> Optional.of(COMPLETED);
            case COMPLETED -> Optional.of(FINISHED);
            default -> Optional.empty();
        };
    }

    public boolean canTransitionTo(OrderStatus newStatus) {
        if (newStatus == CANCELED) {
            return this != CANCELED && this != FINISHED;
        }

        return next().filter(n -> n == newStatus).isPresent();
    }
}
