package com.fiap.grupo186.techchallenge.application.ports.in.salles;

import com.fiap.grupo186.techchallenge.domains.sales.models.Product;

import java.util.List;

public interface ListCategoryUseCase {
    List<Product> execute(String categoryName);
}
