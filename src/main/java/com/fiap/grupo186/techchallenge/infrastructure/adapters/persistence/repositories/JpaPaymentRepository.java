package com.fiap.grupo186.techchallenge.infrastructure.adapters.persistence.repositories;

import com.fiap.grupo186.techchallenge.application.ports.out.PaymentRepositoryPort;
import com.fiap.grupo186.techchallenge.domains.payment.Payment;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class JpaPaymentRepository implements PaymentRepositoryPort {
    @Override
    public Payment findById(UUID paymentId) {
        //TODO: Add persistence method and details
        //  remove this fake Payment when persistence is implemented
        return new Payment(
            paymentId,
            LocalDateTime.now()
        );
    }
}
