package com.fiap.grupo186.techchallenge.domains.sales;

import java.math.BigDecimal;

public record Product (
    String name,
    String description,
    BigDecimal price,

    Category category
){
    public enum Category {
        BURGER,
        SIDE,
        DRINK,
        DESSERT;
    }
}
