package com.fiap.grupo186.techchallenge.domains.kitchen.ports.interfaces;

import com.fiap.grupo186.techchallenge.domains.kitchen.Order;
import com.fiap.grupo186.techchallenge.domains.kitchen.dtos.PreOrderDTO;

public interface OrderServicePort {
    Order create(PreOrderDTO preOrder);
}
