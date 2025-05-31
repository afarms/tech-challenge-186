package com.fiap.grupo186.techchallenge.infrastructure.adapters.persistence.entities.kitchen;

import com.fiap.grupo186.techchallenge.domains.kitchen.models.OrderStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "queue_orders")
public class QueueOrderEntity {
    @Id
    private UUID id;
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "order_id", nullable = false, unique = true)
    private OrderEntity orderEntity;
    @Column(name = "order_status")
    private OrderStatus orderStatus;
    @Column(name = "order_combo")
    private String orderCombo;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "removed_at")
    private LocalDateTime removedAt;

    public QueueOrderEntity() {
    }

    public QueueOrderEntity(
        OrderEntity orderEntity,
        OrderStatus orderStatus,
        String orderCombo
    ) {
        this.id = UUID.randomUUID();
        this.orderEntity = orderEntity;
        this.orderStatus = orderStatus;
        this.orderCombo = orderCombo;
        this.createdAt = LocalDateTime.now();
        this.removedAt = null;
    }

    public UUID getId() {
        return id;
    }

    public OrderEntity getOrderEntity() {
        return orderEntity;
    }

    public void setOrderEntity(OrderEntity orderEntity) {
        this.orderEntity = orderEntity;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderCombo() {
        return orderCombo;
    }

    public void setOrderCombo(String orderCombo) {
        this.orderCombo = orderCombo;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getRemovedAt() {
        return removedAt;
    }

    public void setRemovedAt(LocalDateTime removedAt) {
        this.removedAt = removedAt;
    }
}
