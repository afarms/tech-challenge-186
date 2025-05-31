package com.fiap.grupo186.techchallenge.infrastructure.adapters.persistence.entities.sales.mappers;

import com.fiap.grupo186.techchallenge.domains.sales.models.ComboProduct;
import com.fiap.grupo186.techchallenge.infrastructure.adapters.persistence.entities.sales.ComboEntity;
import com.fiap.grupo186.techchallenge.infrastructure.adapters.persistence.entities.sales.ComboProductEntity;

public class ComboProductMapper {

    public static ComboProductEntity toEntity (ComboProduct comboProduct, ComboEntity comboEntity){
        return new ComboProductEntity(
            comboProduct.id(),
            comboEntity,
            ProductMapper.toEntity(comboProduct.product()),
            comboProduct.quantity()
        );
    }

    public static ComboProduct toDomain(ComboProductEntity entity) {
        return new  ComboProduct(
            entity.getId(),
            entity.getCombo().getId(),
            ProductMapper.toDomain(entity.getProduct()),
            entity.getQuantity()
        );
    }
}
