package com.fiap.grupo186.techchallenge.application.adapters.controllers;

import com.fiap.grupo186.techchallenge.domains.kitchen.Order;
import com.fiap.grupo186.techchallenge.domains.kitchen.dtos.PreOrderDTO;
import com.fiap.grupo186.techchallenge.domains.kitchen.ports.interfaces.OrderServicePort;
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
    private final OrderServicePort orderServicePort;

    public OrderController(OrderServicePort orderServicePort) {
        this.orderServicePort = orderServicePort;
    }

    @PostMapping
    @Operation(summary = "Create a new order", description = "Return 201 if the order was successfully created.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Order created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data in request body")
    })
    public ResponseEntity<Order> createOrder(@RequestBody PreOrderDTO preOrder){
        var order = orderServicePort.create(preOrder);
        return status(CREATED).body(order);
    }

}
