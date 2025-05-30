package com.fiap.grupo186.techchallenge.application.ports.in;

import com.fiap.grupo186.techchallenge.application.dtos.PaymentOrderDTO;

import java.util.UUID;

public interface ConfirmOrderPaymentUseCase {
    void execute(PaymentOrderDTO dto);
}
