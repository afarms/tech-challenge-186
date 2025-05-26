package com.fiap.grupo186.techchallenge.application.ports;

import com.fiap.grupo186.techchallenge.application.dtos.PreOrderDTO;
import com.fiap.grupo186.techchallenge.domains.kitchen.models.Order;

public interface CreatOrderPort {
    Order execute(PreOrderDTO dto);
}
