package com.fiap.grupo186.techchallenge.infrastructure.config;

import com.fiap.grupo186.techchallenge.domains.kitchen.services.KitchenService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    // Domain service unused Spring Bean
    @Bean
    public KitchenService KitchenService() {
        return new KitchenService();
    }
}
