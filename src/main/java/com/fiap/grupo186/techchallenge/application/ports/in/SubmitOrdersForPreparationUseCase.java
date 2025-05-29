package com.fiap.grupo186.techchallenge.application.ports.in;

import com.fiap.grupo186.techchallenge.application.dtos.OrdersIdsDTO;

public interface SubmitOrdersForPreparationUseCase {
    void execute(OrdersIdsDTO orderId);
}
