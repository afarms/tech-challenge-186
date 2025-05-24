package com.fiap.grupo186.techchallenge.domains.kitchen;

import com.fiap.grupo186.techchallenge.domains.kitchen.dtos.PreOrderDTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class Order {
    private final UUID id;
    private BigDecimal price;
    private OrderStatus status;
    private TypeCombo combo;
    private LocalDateTime createdAt;
    private LocalDateTime completedAt = null;
    private List<Item> itemList = new ArrayList<>();

    public Order( TypeCombo combo, LocalDateTime createdAt, BigDecimal price) {
        this.id = UUID.randomUUID();
        this.status = OrderStatus.DRAFT;
        this.combo = combo;
        this.createdAt = createdAt;
        this.price = price;
    }
    public Order(PreOrderDTO preOrder) {
        this.id = UUID.randomUUID();
        this.combo = preOrder.combo();;
        this.status = OrderStatus.DRAFT;
        this.createdAt = LocalDateTime.now(); //TODO: handle time zone
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setCombo(TypeCombo combo) {
        this.combo = combo;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setCompletedAt(LocalDateTime completedAt) {
        this.completedAt = completedAt;
    }

    public void addItem(Item item) {
        this.itemList.add(item);
    }
    public void finisherOrder() {
        this.completedAt = LocalDateTime.now();
    }

}
