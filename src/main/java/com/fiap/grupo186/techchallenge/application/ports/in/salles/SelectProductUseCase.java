package com.fiap.grupo186.techchallenge.application.ports.in.salles;

import com.fiap.grupo186.techchallenge.application.dtos.SelectedProductsTDO;

public interface SelectProductUseCase {
    void execute(SelectedProductsTDO tdo);
}
