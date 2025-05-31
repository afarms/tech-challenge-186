package com.fiap.grupo186.techchallenge.infrastructure.adapters.persistence.entities.sales;

import com.fiap.grupo186.techchallenge.domains.sales.models.ComboType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "combo_type")
public class ComboTypeEntity {

    @Id
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false, unique = true)
    private ComboType.Type type;

    @Column(name = "name", length = 255)
    private String name;
    @Column(name = "image_url", length = 255)
    private String imageUrl;
    @Column(name = "description", length = 255)
    private String description;

    public ComboTypeEntity(
        UUID id,
        ComboType.Type type,
        String name,
        String imageUrl,
        String description
    ) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.imageUrl = imageUrl;
        this.description = description;
    }

    public ComboTypeEntity() {

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ComboType.Type getType() {
        return type;
    }

    public void setType(ComboType.Type type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComboTypeEntity that = (ComboTypeEntity) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
