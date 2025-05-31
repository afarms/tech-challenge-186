package com.fiap.grupo186.techchallenge.infrastructure.adapters.persistence.repositories;

import com.fiap.grupo186.techchallenge.application.ports.out.ComboProductRepositoryPort;
import com.fiap.grupo186.techchallenge.domains.sales.models.ComboProduct;
import com.fiap.grupo186.techchallenge.infrastructure.adapters.persistence.entities.sales.ComboProductEntity;
import com.fiap.grupo186.techchallenge.infrastructure.adapters.persistence.entities.sales.mappers.ComboProductMapper;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class JpaComboProductRepository implements ComboProductRepositoryPort {

    @Override
    public ComboProduct findAllByIds(UUID id) {
        var entity = new ComboProductEntity();
        return ComboProductMapper.toDomain(entity);
    }
}
