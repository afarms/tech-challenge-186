package com.fiap.grupo186.techchallenge.application.handlers.sales;

import com.fiap.grupo186.techchallenge.application.ports.out.ComboTypeRepositoryPort;
import com.fiap.grupo186.techchallenge.application.ports.in.salles.ListComboTypesUseCase;
import com.fiap.grupo186.techchallenge.domains.sales.ComboType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListComboTypesHandler implements ListComboTypesUseCase {
    private final ComboTypeRepositoryPort comboTypeRepository;

    public ListComboTypesHandler(ComboTypeRepositoryPort comboTypeRepository) {
        this.comboTypeRepository = comboTypeRepository;
    }

    @Override
    public List<ComboType> execute() {
        return comboTypeRepository.findAllCombosType();
    }
}
