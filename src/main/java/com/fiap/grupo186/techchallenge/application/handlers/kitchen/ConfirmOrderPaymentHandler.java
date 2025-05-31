package com.fiap.grupo186.techchallenge.application.handlers.kitchen;

import com.fiap.grupo186.techchallenge.application.dtos.PaymentOrderDTO;
import com.fiap.grupo186.techchallenge.application.ports.out.OrderRepositoryPort;
import com.fiap.grupo186.techchallenge.application.ports.in.kitchen.ConfirmOrderPaymentUseCase;
import com.fiap.grupo186.techchallenge.application.ports.out.PaymentRepositoryPort;
import com.fiap.grupo186.techchallenge.domains.kitchen.models.OrderStatus;
import com.fiap.grupo186.techchallenge.domains.kitchen.services.KitchenService;
import com.fiap.grupo186.techchallenge.domains.payment.Payment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ConfirmOrderPaymentHandler implements ConfirmOrderPaymentUseCase {

    private static final Logger logger = LoggerFactory.getLogger(ConfirmOrderPaymentHandler.class);
    private final OrderRepositoryPort orderRepository;
    private final PaymentRepositoryPort paymentRepository;
    private final KitchenService service;

    public ConfirmOrderPaymentHandler(
        OrderRepositoryPort orderRepository,
        KitchenService service,
        PaymentRepositoryPort paymentRepository
    ) {
        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
        this.service = service;
    }

    @Override
    public void execute(PaymentOrderDTO dto){
        UUID orderId = dto.orderId();
        Payment payment = paymentRepository.findById(dto.paymentId());
        var paymentIsValid = payment.isPaid();
        if(!paymentIsValid) {
            var msg = String.format("Payment is invalid! payment id: %s", dto.paymentId());
            logger.warn(msg);
            throw new IllegalArgumentException(msg);
        }

        var order = orderRepository.findById(orderId);
        service.updateStatusOrder(order, OrderStatus.PAYED);
        order.setPaidAt(payment.getCreatedAt());
        orderRepository.save(order);
        logger.info("Successful payment for Order ID: {}", orderId);
    }
}
