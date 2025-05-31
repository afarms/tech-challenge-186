package com.fiap.grupo186.techchallenge.domains.sales.models;

import java.util.UUID;

public record ComboType(
    UUID id,
    Type type,
    String name,
    String imageUrl, //Verify if necessary
    String description
)
{

    public enum Type {
        SINGLE,
        DOUBLE,
        CUSTOMIZED
    }

}
