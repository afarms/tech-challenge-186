package com.fiap.grupo186.techchallenge.application.handlers.kitchen;

import com.fiap.grupo186.techchallenge.application.dtos.OrdersIdsDTO;
import com.fiap.grupo186.techchallenge.application.ports.in.kitchen.SubmitOrdersForPreparationUseCase;
import com.fiap.grupo186.techchallenge.application.ports.out.OrderQueueRepositoryPort;
import com.fiap.grupo186.techchallenge.domains.kitchen.models.Order;
import com.fiap.grupo186.techchallenge.domains.kitchen.models.OrderStatus;
import com.fiap.grupo186.techchallenge.domains.kitchen.services.InvalidStatusException;
import com.fiap.grupo186.techchallenge.domains.kitchen.services.KitchenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class SubmitOrdersForPreparationHandler implements SubmitOrdersForPreparationUseCase {
    private static final Logger logger = LoggerFactory.getLogger(SubmitOrdersForPreparationHandler.class);
    private final OrderQueueRepositoryPort orderQueueRepository;
    private final KitchenService kitchenService;

    public SubmitOrdersForPreparationHandler(
        OrderQueueRepositoryPort orderQueueRepository,
        KitchenService kitchenService
    ) {
        this.orderQueueRepository = orderQueueRepository;
        this.kitchenService = kitchenService;
    }

    @Override
    public void execute(OrdersIdsDTO dto) {
        var orderIdList = dto.ids();
        List<Order> nextOrders = orderQueueRepository.nextOrdersForPreparation(orderIdList.size());

        List<Order> successUpdated = new ArrayList<>();
        List<UUID> failedUpdated = new ArrayList<>();

        Set<UUID> orderIdSet = new HashSet<>(orderIdList);

        for (Order order : nextOrders) {
            if (orderIdSet.contains(order.getId())) {
                try {
                    kitchenService.updateStatusOrder(order, OrderStatus.IN_PREPARATION);
                    successUpdated.add(order);
                } catch (InvalidStatusException e) {
                    failedUpdated.add(order.getId());
                }
            }
        }

        // Orders that were not in the queue at the right time
        Set<UUID> successUpdatedIds = successUpdated.stream()
            .map(Order::getId)
            .collect(Collectors.toSet());
        for (UUID orderId : orderIdList) {
            if (!successUpdatedIds.contains(orderId)) {
                failedUpdated.add(orderId);
            }
        }

        if(!failedUpdated.isEmpty()) {
            logger.warn("Failed to update {} out of {} orders: {}",
                failedUpdated.size(),
                orderIdList.size(),
                failedUpdated);
        }
    }
}
