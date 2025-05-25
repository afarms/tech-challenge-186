package com.fiap.grupo186.techchallenge.domains.kitchen.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import java.util.UUID;

public class Order {
    private final UUID id;
    private BigDecimal price;
    private OrderStatus status;
    private TypeCombo combo;
    private LocalDateTime createdAt;
    private LocalDateTime completedAt = null;
    private List<Item> itemList = new ArrayList<>();

    public Order( TypeCombo combo, BigDecimal price) {
        this.id = UUID.randomUUID();
        this.status = OrderStatus.DRAFT;
        this.combo = combo;
        this.createdAt = LocalDateTime.now();
        this.price = price;
    }

    public void addItem(Item item) {
        this.itemList.add(item);
    }
    public void finisherOrder() {
        this.completedAt = LocalDateTime.now();
    }

    public UUID getId() {
        return id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public TypeCombo getCombo() {
        return combo;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getCompletedAt() {
        return completedAt;
    }

    public List<Item> getItemList() {
        return itemList;
    }
    @Override
    public String toString() {
        return "Order{" +
            "id=" + id +
            ", price=" + price +
            ", status=" + status +
            ", combo=" + combo +
            ", createdAt=" + createdAt +
            ", completedAt=" + completedAt +
            ", itemList=" + itemList +
            "} ";
    }

    public boolean totalPriceValidation() {
        var totalPrice = this.itemList.stream()
                .map(item -> item.getUnitPrice()
                    .multiply(BigDecimal.valueOf(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return totalPrice.compareTo(this.price) == 0;
    }
}
