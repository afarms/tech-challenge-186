package com.fiap.grupo186.techchallenge.application.ports.in;

import com.fiap.grupo186.techchallenge.application.dtos.PreOrderDTO;
import com.fiap.grupo186.techchallenge.domains.kitchen.models.Order;

public interface CreatOrderUseCase {
    Order execute(PreOrderDTO dto);
}
