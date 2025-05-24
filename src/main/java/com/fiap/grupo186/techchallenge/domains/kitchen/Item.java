package com.fiap.grupo186.techchallenge.domains.kitchen;

import com.fiap.grupo186.techchallenge.domains.kitchen.Item.Product.ProductCategory;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Item {
    private final UUID id;
    private Order order;
    private Product product;
    private final Integer quantity;
    private final ProductCategory category;
    private final BigDecimal unitPrice;
    private String customerNote;

    //Snapshot product data
    private UUID productId;
    private String productName;
    private String productDescription;
    private BigDecimal productPrice;
    private LocalDateTime productCreatedAt;
    private boolean productIsAvailable;

    public Item(
        Order order,
        Product product,
        Integer quantity,
        ProductCategory category,
        BigDecimal unitPrice,
        String customerNote,
        UUID productId,
        String productName,
        BigDecimal productPrice,
        String productDescription,
        LocalDateTime productCreatedAt,
        boolean productIsAvailable
    ) {
        this.id = UUID.randomUUID();
        this.order = order;
        this.product = product;
        this.quantity = quantity;
        this.category = category;
        this.unitPrice = unitPrice;
        this.customerNote = customerNote;
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
        this.productCreatedAt = productCreatedAt;
        this.productIsAvailable = productIsAvailable;
    }

    public Integer getQuantity() {
        return this.quantity;
    }
    public BigDecimal getUnitPrice() {
        return this.unitPrice;
    }

    //TODO: Maybe need move Product class to another domain
    public static class Product {
        private UUID id;
        private String name;
        private String description;

        private BigDecimal price;
        private Boolean available;
        private ProductCategory category;
        private LocalDateTime createdAt;

        public Product(UUID id,
                       String name,
                       String description,
                       BigDecimal price,
                       Boolean available,
                       ProductCategory category,
                       LocalDateTime createdAt) {
            this.id = id;
            this.name = name;
            this.description = description;
            this.price = price;
            this.available = available;
            this.category = category;
            this.createdAt = createdAt;

        }

        public UUID getId() {
            return id;
        }

        public String getName() {
            return this.name;
        }

        public BigDecimal getPrice() {
            return this.price;
        }

        public String getDescription() {
            return this.description;
        }

        public LocalDateTime getCreatedAt() {
            return this.createdAt;
        }

        public boolean getIsAvailable() {
            return this.available;
        }

        public enum ProductCategory {
            BURGER,
            SIDE,
            DRINK,
            DESSERT;
        }
    }
}
