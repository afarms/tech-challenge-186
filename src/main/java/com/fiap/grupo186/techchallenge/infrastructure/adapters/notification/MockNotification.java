package com.fiap.grupo186.techchallenge.infrastructure.adapters.notification;

import com.fiap.grupo186.techchallenge.application.ports.out.CustomerNotification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MockNotification implements CustomerNotification {
    private final Logger logger = LoggerFactory.getLogger(MockNotification.class);
    @Override
    public void notifyCustomer(String message, UUID customerId) {
        // Simulate sending a notification
        logger.info(message);
    }
}
