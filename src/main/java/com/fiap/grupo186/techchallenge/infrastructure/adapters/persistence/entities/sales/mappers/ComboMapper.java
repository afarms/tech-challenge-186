package com.fiap.grupo186.techchallenge.infrastructure.adapters.persistence.entities.sales.mappers;

import com.fiap.grupo186.techchallenge.domains.sales.models.Combo;
import com.fiap.grupo186.techchallenge.infrastructure.adapters.persistence.entities.sales.ComboEntity;

import java.time.LocalDateTime;

public class ComboMapper {

    public static ComboEntity toEntity(Combo combo) {

        var comboEntity = new ComboEntity();
        var comboProductEntityList = combo.getComboProducts().stream()
            .map(comboProduct -> ComboProductMapper.toEntity(comboProduct, comboEntity))
            .toList();

        comboEntity.setId(combo.getId());
        comboEntity.setType(combo.getType().name());
        comboEntity.setCustomerNote(combo.getCustomerNote());
        comboEntity.setPrice(combo.getPrice());
        comboEntity.setComboProducts(comboProductEntityList);
        comboEntity.setCreatedAt(LocalDateTime.now());

        return comboEntity;
    }
}
