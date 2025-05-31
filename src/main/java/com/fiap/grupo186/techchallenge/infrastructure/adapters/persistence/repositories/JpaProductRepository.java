package com.fiap.grupo186.techchallenge.infrastructure.adapters.persistence.repositories;

import com.fiap.grupo186.techchallenge.application.ports.out.ProductRepositoryPort;
import com.fiap.grupo186.techchallenge.domains.sales.models.Product;
import com.fiap.grupo186.techchallenge.infrastructure.adapters.persistence.entities.sales.ProductEntity;
import com.fiap.grupo186.techchallenge.infrastructure.adapters.persistence.entities.sales.mappers.ProductMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class JpaProductRepository implements ProductRepositoryPort {
    //TODO: Implement the persistence logic
    @Override
    public List<Product> findAllProductsByCategory(String category) {
        return List.of();
    }

    @Override
    public Product findById(UUID id) {
        var entity = new ProductEntity();
        return ProductMapper.toDomain(entity);
    }
}
