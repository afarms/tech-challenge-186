package com.fiap.grupo186.techchallenge.application.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record PaymentOrderDTO(
    @NotNull
    UUID orderId,

    @NotNull
    UUID paymentId
    //String paymentMethod,
    //String paymentStatus,
    //String transactionId
) {
}
