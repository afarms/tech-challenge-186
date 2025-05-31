package com.fiap.grupo186.techchallenge.infrastructure.adapters.persistence.entities.kitchen;

import com.fiap.grupo186.techchallenge.domains.kitchen.models.Item;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "items")
public class ItemEntity {

    @Id
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity orderEntity;
    private int quantity;
    @Column(name = "unit_price", precision = 10, scale = 2)
    private BigDecimal unitPrice;
    @Column(name = "customer_note")
    private String customerNote;
    @Column(name = "product_id")
    private UUID productId;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "product_category")
    private Item.ProductCategory productCategory;
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public ItemEntity() {
    }

    public ItemEntity(UUID id, OrderEntity orderEntity, int quantity, BigDecimal unitPrice, String customerNote, UUID productId, String productName, Item.ProductCategory productCategory, LocalDateTime createdAt) {
        this.id = id;
        this.orderEntity = orderEntity;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.customerNote = customerNote;
        this.productId = productId;
        this.productName = productName;
        this.productCategory = productCategory;
        this.createdAt = createdAt;
    }

    public UUID id() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public OrderEntity orderEntity() {
        return orderEntity;
    }

    public void setOrderEntity(OrderEntity orderEntity) {
        this.orderEntity = orderEntity;
    }

    public int quantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal unitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String customerNote() {
        return customerNote;
    }

    public void setCustomerNote(String customerNote) {
        this.customerNote = customerNote;
    }

    public UUID productId() {
        return productId;
    }

    public void setProductId(UUID productId) {
        this.productId = productId;
    }

    public String productName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Item.ProductCategory productCategory() {
        return productCategory;
    }

    public void setProductCategory(Item.ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public LocalDateTime createdAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
