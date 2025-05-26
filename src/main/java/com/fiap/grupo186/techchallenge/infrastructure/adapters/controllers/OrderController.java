package com.fiap.grupo186.techchallenge.infrastructure.adapters.controllers;

import com.fiap.grupo186.techchallenge.application.dtos.UpdateStatusDTO;
import com.fiap.grupo186.techchallenge.application.ports.CreatOrderUseCase;
import com.fiap.grupo186.techchallenge.application.ports.UpdateStatusOrderUseCase;
import com.fiap.grupo186.techchallenge.domains.kitchen.models.Order;
import com.fiap.grupo186.techchallenge.application.dtos.PreOrderDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final CreatOrderUseCase creatOrderUseCase;
    private final UpdateStatusOrderUseCase updateStatusOrderUseCase;

    public OrderController(
        CreatOrderUseCase creatOrderUseCase,
        UpdateStatusOrderUseCase updateStatusOrderUseCase
    ) {
        this.creatOrderUseCase = creatOrderUseCase;
        this.updateStatusOrderUseCase = updateStatusOrderUseCase;
    }

    @PostMapping
    @Operation(summary = "Create a new order", description = "Return 201 if the order was successfully created.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Order created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data in request body")
    })
    public ResponseEntity<Order> createOrder(@RequestBody @Valid PreOrderDTO preOrder){
        var order = creatOrderUseCase.execute(preOrder);
        return status(CREATED).body(order);
    }

    @PatchMapping("/{id}/status")
    @Operation(summary = "Update the status order", description = "Return 204 if the order status was successfully updated.")
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "Order status updated successfully"),
        @ApiResponse(responseCode = "422", description = "Invalid update status"),
    })
    public ResponseEntity<Void> updateStatus(
        @PathVariable UUID id,
        @RequestBody @Valid UpdateStatusDTO dto) {

        updateStatusOrderUseCase.execute(id, dto.status());

        return ResponseEntity.noContent().build();
    }

}
