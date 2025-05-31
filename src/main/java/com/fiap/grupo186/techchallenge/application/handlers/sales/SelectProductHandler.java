package com.fiap.grupo186.techchallenge.application.handlers.sales;

import com.fiap.grupo186.techchallenge.application.dtos.SelectedProductsTDO;
import com.fiap.grupo186.techchallenge.application.ports.in.salles.SelectProductUseCase;
import com.fiap.grupo186.techchallenge.application.ports.out.ComboRepositoryPort;
import com.fiap.grupo186.techchallenge.application.ports.out.ProductRepositoryPort;
import com.fiap.grupo186.techchallenge.domains.sales.SalesService;
import com.fiap.grupo186.techchallenge.domains.sales.models.Combo;
import com.fiap.grupo186.techchallenge.domains.sales.models.ComboProduct;
import com.fiap.grupo186.techchallenge.domains.sales.models.ComboType;
import com.fiap.grupo186.techchallenge.domains.sales.models.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;


@Service
public class SelectProductHandler implements SelectProductUseCase {
    private final ComboRepositoryPort comboRepository;
    private final ProductRepositoryPort productRepository;
    private final SalesService salesService;

    public SelectProductHandler(
        ComboRepositoryPort comboRepository,
        ProductRepositoryPort productRepository,
        SalesService salesService
    ) {
        this.comboRepository = comboRepository;
        this.productRepository = productRepository;
        this.salesService = salesService;
    }

    @Override
    public void execute(SelectedProductsTDO dto) {
        var type = ComboType.Type.valueOf(dto.comboType().toLowerCase());
        Combo combo = new Combo(type, dto.CustomerNotes());

        var productsCategory = dto.products().stream()
            .map(SelectedProductsTDO.Product::category)
            .toList();
        salesService.validateCategorySequence(productsCategory);

        List<ComboProduct> comboProducts = dto.products().stream()
            .map(product -> new ComboProduct(
                UUID.randomUUID(),
                combo.getId(),
                productRepository.findById(product.id()),
                product.quantity()
            ))
            .toList();

        var price = comboProducts.stream().
            map(ComboProduct::product)
            .map(Product::price)
            .reduce(BigDecimal.ZERO, BigDecimal::add);

        combo.setComboProducts(comboProducts);
        combo.setPrice(price);

        salesService.comboValidate(combo);
        comboRepository.save(combo);
    }
}
