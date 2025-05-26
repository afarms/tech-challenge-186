package com.fiap.grupo186.techchallenge.application.dtos;

import com.fiap.grupo186.techchallenge.domains.kitchen.models.OrderStatus;
import jakarta.validation.constraints.NotNull;

public record UpdateStatusDTO(
    @NotNull(message = "Status must not be null")
    OrderStatus status
) {
}
