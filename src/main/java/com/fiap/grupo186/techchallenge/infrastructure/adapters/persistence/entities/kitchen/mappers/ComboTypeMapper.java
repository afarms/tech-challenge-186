package com.fiap.grupo186.techchallenge.infrastructure.adapters.persistence.entities.kitchen.mappers;

import com.fiap.grupo186.techchallenge.domains.sales.models.ComboType;
import com.fiap.grupo186.techchallenge.infrastructure.adapters.persistence.entities.sales.ComboTypeEntity;

public class ComboTypeMapper {

    static ComboType toModel(ComboTypeEntity entity){
        return new ComboType(
            entity.getId(),
            entity.getType(),
            entity.getName(),
            entity.getImageUrl(),
            entity.getDescription()
        );
    }
}
