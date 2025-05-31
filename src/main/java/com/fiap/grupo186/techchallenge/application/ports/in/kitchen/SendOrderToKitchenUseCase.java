package com.fiap.grupo186.techchallenge.application.ports.in.kitchen;

import java.util.UUID;

public interface SendOrderToKitchenUseCase {
    void execute(UUID orderId);
}
