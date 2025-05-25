package com.fiap.grupo186.techchallenge.domains.kitchen.services;

import com.fiap.grupo186.techchallenge.domains.kitchen.models.Order;
public class KitchenService {
    public KitchenService(){
    }
    public void validarRegrasNegocio(Order order) {
        if(!order.totalPriceValidation()){
            throw new IllegalArgumentException("Order total price is invalid!");
        }
    }
}
