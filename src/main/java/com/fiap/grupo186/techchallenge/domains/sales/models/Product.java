package com.fiap.grupo186.techchallenge.domains.sales.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record Product (
    UUID id,
    String name,
    String description,
    BigDecimal price,
    Category category,
    LocalDateTime createdAt,
    LocalDateTime unavailable,
    Boolean available

){
    public enum Category {
        BURGER(0),
        SIDE(1),
        DRINK(2),
        DESSERT(3);

        private final int rank;

        Category(int rank) {
            this.rank = rank;
        }

        public int getRank(){
            return this.rank;
        }
    }

}
