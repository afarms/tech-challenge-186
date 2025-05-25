package com.fiap.grupo186.techchallenge.infrastructure.adapters.controllers;

import com.fiap.grupo186.techchallenge.application.usecases.CreateOrderUseCase;
import com.fiap.grupo186.techchallenge.domains.kitchen.models.Order;
import com.fiap.grupo186.techchallenge.application.dtos.PreOrderDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final CreateOrderUseCase createOrderUserCase;

    public OrderController(CreateOrderUseCase createOrderUserCase) {
        this.createOrderUserCase = createOrderUserCase;
    }

    @PostMapping
    @Operation(summary = "Create a new order", description = "Return 201 if the order was successfully created.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Order created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data in request body")
    })
    public ResponseEntity<Order> createOrder(@RequestBody PreOrderDTO preOrder){
        var order = createOrderUserCase.execute(preOrder);
        return status(CREATED).body(order);
    }

}
