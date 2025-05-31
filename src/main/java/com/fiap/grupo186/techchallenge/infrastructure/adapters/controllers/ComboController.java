package com.fiap.grupo186.techchallenge.infrastructure.adapters.controllers;

import com.fiap.grupo186.techchallenge.application.ports.in.salles.ListComboTypesUseCase;
import com.fiap.grupo186.techchallenge.domains.sales.ComboType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/combos")
public class ComboController {
    private final ListComboTypesUseCase listComboTypesUseCase;

    public ComboController(ListComboTypesUseCase listComboTypesUseCase) {
        this.listComboTypesUseCase = listComboTypesUseCase;
    }

    @GetMapping("/types")
    @Operation(
        summary = "Obtém todos os tipos de combo disponíveis",
        description = "Retorna uma lista completa de todos os tipos de combo cadastrados no sistema.",
        tags = {"Combo Types"},
        responses = {
            @ApiResponse(
                responseCode = "200",
                description = "Lista de tipos de combo retornada com sucesso."
            )
        }
    )
    public ResponseEntity<List<ComboType>> getAllCombosTypes() {
        var comboList = listComboTypesUseCase.execute();
        return ResponseEntity.ok().body(comboList);
    }
}
