package com.fiap.grupo186.techchallenge.infrastructure.config;

import com.fiap.grupo186.techchallenge.domains.kitchen.adapters.services.KitchenService;
import com.fiap.grupo186.techchallenge.domains.kitchen.ports.interfaces.OrderServicePort;
import com.fiap.grupo186.techchallenge.domains.kitchen.ports.repositories.OrderRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    OrderServicePort orderService(OrderRepositoryPort orderRepositoryPort){
        return new KitchenService(orderRepositoryPort);
    }
}
