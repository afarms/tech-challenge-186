package com.fiap.grupo186.techchallenge.application.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.UUID;

public record OrdersIdsDTO(
    @NotNull(message = "Item must not be null")
    @Size(min = 1, message = "Must have at least one item")
    List<UUID> ids
) {
}
