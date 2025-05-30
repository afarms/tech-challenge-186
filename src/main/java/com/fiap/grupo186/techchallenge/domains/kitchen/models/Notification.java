package com.fiap.grupo186.techchallenge.domains.kitchen.models;

public record Notification(
    String customerName,
    String message,
    String orderId
) {
}