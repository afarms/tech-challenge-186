package com.fiap.grupo186.techchallenge.infrastructure.adapters.controllers;

import com.fiap.grupo186.techchallenge.application.dtos.OrdersIdsDTO;
import com.fiap.grupo186.techchallenge.application.dtos.PaymentOrderDTO;
import com.fiap.grupo186.techchallenge.application.ports.in.CancelOrderUseCase;
import com.fiap.grupo186.techchallenge.application.ports.in.CreatOrderUseCase;
import com.fiap.grupo186.techchallenge.application.ports.in.ConfirmOrderPaymentUseCase;
import com.fiap.grupo186.techchallenge.application.ports.in.OrderCompletedUseCase;
import com.fiap.grupo186.techchallenge.application.ports.in.OrderReadyUseCase;
import com.fiap.grupo186.techchallenge.application.ports.in.SendOrderToKitchenUseCase;
import com.fiap.grupo186.techchallenge.application.ports.in.SubmitOrdersForPreparationUseCase;
import com.fiap.grupo186.techchallenge.domains.kitchen.models.Order;
import com.fiap.grupo186.techchallenge.application.dtos.PreOrderDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final CreatOrderUseCase creatOrderUseCase;
    private final ConfirmOrderPaymentUseCase confirmOrderPaymentUseCase;
    private final SendOrderToKitchenUseCase sendOrderToKitchenUseCase;
    private final SubmitOrdersForPreparationUseCase submitOrdersForPreparationUseCase;
    private final CancelOrderUseCase cancelOrderUseCase;
    private final OrderReadyUseCase orderReadyUseCase;
    private final OrderCompletedUseCase orderCompletedUseCase;

    public OrderController(
        CreatOrderUseCase creatOrderUseCase,
        ConfirmOrderPaymentUseCase confirmOrderPaymentUseCase,
        SendOrderToKitchenUseCase sendOrderToKitchenUseCase,
        SubmitOrdersForPreparationUseCase submitOrdersForPreparationUseCase,
        CancelOrderUseCase cancelOrderUseCase,
        OrderReadyUseCase orderReadyUseCase,
        OrderCompletedUseCase orderCompletedUseCase
    ) {
        this.creatOrderUseCase = creatOrderUseCase;
        this.confirmOrderPaymentUseCase = confirmOrderPaymentUseCase;
        this.sendOrderToKitchenUseCase = sendOrderToKitchenUseCase;
        this.submitOrdersForPreparationUseCase = submitOrdersForPreparationUseCase;
        this.cancelOrderUseCase = cancelOrderUseCase;
        this.orderReadyUseCase = orderReadyUseCase;
        this.orderCompletedUseCase = orderCompletedUseCase;
    }

    @PostMapping
    @Operation(
        summary = "Create a new order.",
        description = "Return 201 if the order was successfully created."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Order created successfully."),
            @ApiResponse(responseCode = "400", description = "Invalid input data in request body.")
    })
    public ResponseEntity<Order> createOrder(@RequestBody @Valid PreOrderDTO preOrder){
        var order = creatOrderUseCase.execute(preOrder);
        return status(CREATED).body(order);
    }

    @PostMapping("/confirm-payment")
    @Operation(
        summary = "Update the status order to payed.",
        description = "Return 204 if the order status was successfully updated."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "Order status updated successfully."),
        @ApiResponse(responseCode = "422", description = "Invalid update status."),
    })
    public ResponseEntity<Void> confirmPayed(@Valid @RequestBody PaymentOrderDTO dto) {
        confirmOrderPaymentUseCase.execute(dto);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/send-kitchen")
    @Operation(
        summary = "Enqueues the specified order in the kitchen queue for preparation.",
        description = "Return 201 if the order was successfully sent to the kitchen."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "Orders queued successfully."),
        @ApiResponse(responseCode = "404", description = "Order not found."),
    })
    public ResponseEntity<Void> sendToKitchen(@Valid @PathVariable UUID id) {
        sendOrderToKitchenUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/send-preparation")
    @Operation(
        summary = "Send list of Orders to preparation. ",
        description = "Return 204 if the orders was successfully sent to the kitchen."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "Orders queued successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid input data"),
        @ApiResponse(responseCode = "404", description = "Orders not found"),
    })
    public ResponseEntity<Void> sendToPreparation(@Valid @RequestBody OrdersIdsDTO orderIds) {
        submitOrdersForPreparationUseCase.execute(orderIds);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/cancel")
    @Operation(
        summary = "Cancel the order.",
        description = "Returns 200 if the order was successfully cancelled."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Order cancelled successfully."),
        @ApiResponse(responseCode = "400", description = "Invalid input data."),
        @ApiResponse(responseCode = "404", description = "Orders not found."),
    })
    public ResponseEntity<Order> cancellation(@PathVariable UUID id) {
        Order order = cancelOrderUseCase.execute(id);
        return ResponseEntity.ok().body(order);
    }

    @PostMapping("/{id}/ready")
    @Operation(
        summary = "Oder ready.",
        description = "Returns 200 if the order was successfully ready."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Order ready successfully."),
        @ApiResponse(responseCode = "400", description = "Invalid input data."),
        @ApiResponse(responseCode = "404", description = "Orders not found."),
    })
    public ResponseEntity<Order> ready(@PathVariable UUID id) {
        Order order = orderReadyUseCase.execute(id);
        return ResponseEntity.ok().body(order);
    }
    @PostMapping("/{id}/complete")
    @Operation(
        summary = "Oder ready.",
        description = "Returns 200 if the order was successfully complete."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Order complete successfully."),
        @ApiResponse(responseCode = "400", description = "Invalid input data."),
        @ApiResponse(responseCode = "404", description = "Orders not found."),
    })
    public ResponseEntity<Order> complete(@PathVariable UUID id) {
        Order order = orderCompletedUseCase.execute(id);
        return ResponseEntity.ok().body(order);
    }
}
