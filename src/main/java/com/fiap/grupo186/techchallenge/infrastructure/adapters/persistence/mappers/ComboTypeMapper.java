package com.fiap.grupo186.techchallenge.infrastructure.adapters.persistence.mappers;

import com.fiap.grupo186.techchallenge.domains.sales.ComboType;
import com.fiap.grupo186.techchallenge.infrastructure.adapters.persistence.entities.ComboTypeEntity;

public class ComboTypeMapper {

    static ComboType toModel(ComboTypeEntity entity){
        return new ComboType(
            entity.getId(),
            entity.getType(),
            entity.getName(),
            entity.getDescription()
        );
    }
}
