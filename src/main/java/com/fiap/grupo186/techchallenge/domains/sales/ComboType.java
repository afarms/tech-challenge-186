package com.fiap.grupo186.techchallenge.domains.sales;

import java.util.UUID;

public class ComboType {
    private final UUID id;
    private final Type type;
    private final String name;
    private final String description;

    public ComboType(
        UUID id,
        Type type,
        String name,
        String description
    ) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.description = description;
    }

    public UUID getId() {
        return id;
    }

    public Type getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public enum Type {
        SINGLE,
        DOUBLE,
        CUSTOMIZED
    }

}
