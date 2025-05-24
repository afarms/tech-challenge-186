package com.fiap.grupo186.techchallenge.domains.kitchen.adapters.services;

import com.fiap.grupo186.techchallenge.domains.kitchen.Order;
import com.fiap.grupo186.techchallenge.domains.kitchen.dtos.PreOrderDTO;
import com.fiap.grupo186.techchallenge.domains.kitchen.ports.interfaces.OrderServicePort;
import com.fiap.grupo186.techchallenge.domains.kitchen.ports.repositories.OrderRepositoryPort;
public class KitchenService implements OrderServicePort {

    private final OrderRepositoryPort orderRepository;

    public  KitchenService(OrderRepositoryPort orderRepository){
        this.orderRepository = orderRepository;
    }
    @Override
    public Order create(PreOrderDTO preOrder) {

        if(!preOrder.totalPriceValidation()){
            throw new IllegalArgumentException("Order total price is invalid!");
        }

        var order = preOrder.makeOrderWithItems();

        //TODO: maybe change to optional for handling errors
        this.orderRepository.save(order);
        return order;
    }
}
