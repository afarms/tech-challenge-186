package com.fiap.grupo186.techchallenge.application.dtos;

import java.util.List;
import java.util.UUID;

public record SelectedProductsTDO(
    String comboType,
    String CustomerNotes,
    List<Product> products
) {
    public record Product(UUID id, String category, Integer quantity){}
}
