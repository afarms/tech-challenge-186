package com.fiap.grupo186.techchallenge.infrastructure.adapters.persistence.entities;

import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Table(name = "payments")
public class PaymentEntity {
    @Id
    private UUID id;
}
