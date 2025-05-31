package com.fiap.grupo186.techchallenge.infrastructure.adapters.controllers;

import com.fiap.grupo186.techchallenge.application.dtos.SelectedProductsTDO;
import com.fiap.grupo186.techchallenge.application.ports.in.salles.ListCategoryUseCase;
import com.fiap.grupo186.techchallenge.domains.sales.models.Product;
import com.fiap.grupo186.techchallenge.infrastructure.config.controller.CategoryParameter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ListCategoryUseCase listCategoryUseCase;

    public ProductController(ListCategoryUseCase listCategoryUseCase) {
        this.listCategoryUseCase = listCategoryUseCase;
    }

    @GetMapping("/{category}")
    @Operation(
        summary = "List all products by category",
        description = "Returns a list of products filtered by the specified category.",
        responses = {
            @ApiResponse(responseCode = "200", description = "List of products by category returned successfully."),
            @ApiResponse(responseCode = "404", description = "Category not found.")
        }
    )
    public ResponseEntity<List<Product>> listProductsByCategory(@CategoryParameter @PathVariable String category){
        var productList = listCategoryUseCase.execute(category);
        return ResponseEntity.ok().body(productList);
    }

    @PostMapping
    @Operation(
        summary = "Select product",
        description = "Allows the selection of product by ID.",
        responses = {
            @ApiResponse(responseCode = "200", description = "Products selected successfully."),
            @ApiResponse(responseCode = "400", description = "Invalid product IDs provided.")
        }
    )
    public ResponseEntity<Void> selectProduct( @RequestBody SelectedProductsTDO tdo) {
        // This method is a placeholder for future implementation.
        // Currently, it does not perform any action.
        return ResponseEntity.ok().build();
    }
}
