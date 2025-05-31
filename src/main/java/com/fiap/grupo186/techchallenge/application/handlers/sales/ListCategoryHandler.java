package com.fiap.grupo186.techchallenge.application.handlers.sales;

import com.fiap.grupo186.techchallenge.application.ports.in.salles.ListCategoryUseCase;
import com.fiap.grupo186.techchallenge.application.ports.out.ProductRepositoryPort;
import com.fiap.grupo186.techchallenge.domains.sales.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListCategoryHandler implements ListCategoryUseCase {
    private final ProductRepositoryPort productRepository;

    public ListCategoryHandler(ProductRepositoryPort productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> execute(String category) {
        return productRepository.findAllProductsByCategory(category.toUpperCase());
    }
}
