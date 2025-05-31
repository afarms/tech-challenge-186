package com.fiap.grupo186.techchallenge.infrastructure.adapters.persistence.repositories;

import com.fiap.grupo186.techchallenge.application.ports.out.ComboRepositoryPort;
import com.fiap.grupo186.techchallenge.domains.sales.models.Combo;
import com.fiap.grupo186.techchallenge.infrastructure.adapters.persistence.entities.sales.mappers.ComboMapper;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class JpaComboRepository implements ComboRepositoryPort {
    @Override
    public Combo findById(UUID id) {
        return null;
    }

    @Override
    public void save(Combo combo) {
        var comboEntity = ComboMapper.toEntity(combo);
    }
}
