package com.fiap.grupo186.techchallenge.infrastructure.adapters.persistence.repositories;

import com.fiap.grupo186.techchallenge.application.ports.out.ComboTypeRepositoryPort;
import com.fiap.grupo186.techchallenge.domains.sales.models.ComboType;
import org.springframework.stereotype.Repository;

import java.util.List;

//TODO: change to JpaRepository<Combo, UUID> when Combo is implemented
// public interface JpaComboRepository extends JpaRepository<Combo, UUID>, ComboRepositoryPort {
@Repository
public class JpaComboTypeRepository implements ComboTypeRepositoryPort {
    @Override
    public List<ComboType> findAllCombosType() {
        return null;
    }
}