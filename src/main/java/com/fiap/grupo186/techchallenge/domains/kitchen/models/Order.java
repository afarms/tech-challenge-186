package com.fiap.grupo186.techchallenge.domains.kitchen.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import java.util.Objects;
import java.util.UUID;

public class Order {
    private final UUID id;
    private BigDecimal price;
    private OrderStatus status;
    private String combo;
    private LocalDateTime createdAt;
    private LocalDateTime completedAt = null;

    private LocalDateTime paidAt = null;
    private List<Item> itemList = new ArrayList<>();

    private final UUID customerId;
    private final String customerName;

    public Order(
        String combo,
        BigDecimal price,
        UUID customerId,
        String customerName) {
        this.id = UUID.randomUUID();
        this.status = OrderStatus.PENDING_PAYMENT;
        this.combo = combo;
        this.createdAt = LocalDateTime.now();
        this.price = price;
        this.customerId = customerId;
        this.customerName = customerName;
    }

    public boolean totalPriceValidation() {
        var totalPrice = this.itemList.stream()
            .map(item -> item.getUnitPrice()
                .multiply(BigDecimal.valueOf(item.getQuantity())))
            .reduce(BigDecimal.ZERO, BigDecimal::add);
        return totalPrice.compareTo(this.price) == 0;
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

    public void setStatus(OrderStatus status){
        this.status = status;
    }

    public String getCombo() {
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

    public void addItem(Item item) {
        this.itemList.add(item);
    }

    public LocalDateTime getPaidAt() {
        return paidAt;
    }

    public void setPaidAt(LocalDateTime paidAt) {
        this.paidAt = paidAt;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
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
            ", paidAt=" + paidAt +
            ", itemList=" + itemList +
            ", customerId=" + customerId +
            ", CustomerName='" + customerName + '\'' +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
