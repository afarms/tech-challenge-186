package com.fiap.grupo186.techchallenge.domains.sales.models;


import com.fiap.grupo186.techchallenge.domains.sales.models.ComboType.Type;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Combo {
    private final UUID id;
    private Type type;
    private String customerNote;
    private BigDecimal price = BigDecimal.ZERO;

    private List<ComboProduct> comboProducts = new ArrayList<>();
    private LocalDateTime createdAt;

    public Combo(
        Type type,
        String customerNote
    ) {
        this.id = UUID.randomUUID();
        this.type =  type;
        this.customerNote = customerNote;
        this.createdAt = LocalDateTime.now();
    }

    public UUID getId() {
        return id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getCustomerNote() {
        return customerNote;
    }

    public void setCustomerNote(String customerNote) {
        this.customerNote = customerNote;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<ComboProduct> getComboProducts() {
        return comboProducts;
    }

    public void setComboProducts(List<ComboProduct> products) {
        this.comboProducts = products;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Combo{" +
            "id=" + id +
            ", type=" + type +
            ", customerNote='" + customerNote + '\'' +
            ", price=" + price +
            ", products=" + comboProducts +
            ", createdAt=" + createdAt +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Combo combo)) return false;
        return Objects.equals(id, combo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}