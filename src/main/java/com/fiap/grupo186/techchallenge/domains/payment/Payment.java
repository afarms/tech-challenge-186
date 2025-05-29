package com.fiap.grupo186.techchallenge.domains.payment;

import java.time.LocalDateTime;
import java.util.UUID;

public class Payment {
    UUID id;
    LocalDateTime createdAt;

    public Payment(
        UUID id,
        LocalDateTime createdAt
    ) {
        this.id = id;
        this.createdAt = createdAt;
    }
    public UUID getId() {
        return id;
    }

    public boolean isPaid() {
        // Logic to determine if the payment is completed
        return true;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
