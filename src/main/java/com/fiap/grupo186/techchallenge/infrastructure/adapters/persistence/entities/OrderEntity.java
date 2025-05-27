package com.fiap.grupo186.techchallenge.infrastructure.adapters.persistence.entities;

import com.fiap.grupo186.techchallenge.domains.kitchen.models.OrderStatus;
import com.fiap.grupo186.techchallenge.domains.kitchen.models.TypeCombo;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "orders")
public class OrderEntity {

    @Id
    private UUID id;
    @Column(precision = 10, scale = 2)
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    @Enumerated(EnumType.STRING)
    private TypeCombo combo;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "completed_at")
    private LocalDateTime completedAt;
    @Column(name = "paid_at")
    private LocalDateTime paidAt;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemEntity> itemList;

    public OrderEntity(
        UUID id,
        BigDecimal price,
        OrderStatus status,
        TypeCombo combo,
        LocalDateTime createdAt,
        LocalDateTime completedAt,
        List<ItemEntity> itemList
    ) {
        this.id = id;
        this.price = price;
        this.status = status;
        this.combo = combo;
        this.createdAt = createdAt;
        this.completedAt = completedAt;
        this.itemList = itemList;
    }

    public OrderEntity() {

    }

    public UUID id() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public BigDecimal price() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public OrderStatus status() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public TypeCombo combo() {
        return combo;
    }

    public void setCombo(TypeCombo combo) {
        this.combo = combo;
    }

    public LocalDateTime createdAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime completedAt() {
        return completedAt;
    }

    public void setCompletedAt(LocalDateTime completedAt) {
        this.completedAt = completedAt;
    }

    public List<ItemEntity> itemList() {
        return itemList;
    }

    public void setItemList(List<ItemEntity> itemList) {
        this.itemList = itemList;
    }

    public LocalDateTime paidAt() {
        return paidAt;
    }

    public void setPaidAt(LocalDateTime paidAt) {
        this.paidAt = paidAt;
    }
}
