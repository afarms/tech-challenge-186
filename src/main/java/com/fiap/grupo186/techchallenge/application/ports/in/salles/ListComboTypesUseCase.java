package com.fiap.grupo186.techchallenge.application.ports.in.salles;

import com.fiap.grupo186.techchallenge.domains.sales.ComboType;

import java.util.List;

public interface ListComboTypesUseCase {
    List<ComboType> execute();
}
