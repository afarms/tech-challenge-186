package com.fiap.grupo186.techchallenge.infrastructure.adapters.persistence.entities.sales;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "combos")
public class ComboEntity {
    @Id
    private UUID id;

    @Column(nullable = false)
    private String type;

    private String customerNote;

    @Column(nullable = false)
    private BigDecimal price;

    @OneToMany(mappedBy = "combo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ComboProductEntity> comboProducts = new ArrayList<>();

    @Column(name = "created_at", nullable = false)
    LocalDateTime createdAt;

    public ComboEntity() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
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

    public List<ComboProductEntity> getComboProducts() {
        return comboProducts;
    }

    public void setComboProducts(List<ComboProductEntity> comboProducts) {
        this.comboProducts = comboProducts;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
