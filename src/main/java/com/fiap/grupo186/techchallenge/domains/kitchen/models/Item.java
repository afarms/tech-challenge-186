package com.fiap.grupo186.techchallenge.domains.kitchen.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Item {
    private final UUID id;
    private final Integer quantity;
    private final BigDecimal unitPrice;
    private final String customerNote;
    //Snapshot product data
    private final UUID productId;
    private final String productName;
    private final ProductCategory productCategory;
    private final LocalDateTime createdAt;

    public Item(
        Integer quantity,
        BigDecimal unitPrice,
        String customerNote,
        UUID productId,
        String productName,
        ProductCategory productCategory
    ) {
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.customerNote = customerNote;
        this.productId = productId;
        this.productName = productName;
        this.productCategory = productCategory;

        this.id = UUID.randomUUID();
        this.createdAt = LocalDateTime.now();
    }

    public UUID getId() {return id;}

    public Integer getQuantity() {return quantity;}

    public BigDecimal getUnitPrice() {return unitPrice;}

    public String getCustomerNote() {return customerNote;}

    public UUID getProductId() {return productId;}

    public String getProductName() {return productName;}

    public ProductCategory getProductCategory() {return productCategory;}

    public LocalDateTime getCreatedAt() {return createdAt;}

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                ", customerNote='" + customerNote + '\'' +
                ", productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productCategory=" + productCategory +
                '}';
    }

    public enum ProductCategory {
        BURGER,
        SIDE,
        DRINK,
        DESSERT;
    }

}
