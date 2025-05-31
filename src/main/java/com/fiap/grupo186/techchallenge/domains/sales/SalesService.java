package com.fiap.grupo186.techchallenge.domains.sales;

import com.fiap.grupo186.techchallenge.domains.sales.models.Combo;
import com.fiap.grupo186.techchallenge.domains.sales.models.ComboProduct;
import com.fiap.grupo186.techchallenge.domains.sales.models.Product;

import java.util.List;

import static java.lang.Math.toIntExact;

public class SalesService {
    private final static int MAX_PRODUCTS = 100;
    private final static int MAX_CATEGORY = 4;

    public void comboValidate(Combo combo) {
        int limit = switch (combo.getType()) {
            case SINGLE -> 1;
            case DOUBLE -> 2;
            case CUSTOMIZED -> MAX_PRODUCTS;
        };

        if(combo.getComboProducts().isEmpty()){
            var msg = String.format("Combo '%s' does not have any products.", combo.getId());
            throw new IllegalArgumentException(msg); //TODO: create a domain specific exception
        }

        var totalBurgers = countProductsByCategoryRank(combo.getComboProducts(), 1);
        var totalSides = countProductsByCategoryRank(combo.getComboProducts(), 2);
        var totalDrinks = countProductsByCategoryRank(combo.getComboProducts(), 3);
        var totalDesserts = countProductsByCategoryRank(combo.getComboProducts(), 4);

        if (
            totalBurgers > limit ||
                totalSides > limit ||
                totalDrinks > limit ||
                totalDesserts > limit
        ) {

            var msg = String.format("Combo '%s' does not respect the item limits for the type: %s. Quantity of item",
                combo.getId(), combo.getType());
            throw new IllegalArgumentException(msg); //TODO: create a domain specific exception
        }
    }

    private int countProductsByCategoryRank(List<ComboProduct> products, int rank) {
        return products.stream()
            .filter(product -> product.getCategory().getRank() == rank)
            .mapToInt(ComboProduct::quantity)
            .sum();
    }

    public void validateCategorySequence(List<String> category) {
        if(category.size() != MAX_CATEGORY){
          var msg = String.format("Combo does not respect the category quantity. Expected %d categories, but got %d.",
              MAX_CATEGORY, category.size());
            throw new IllegalArgumentException(msg); //TODO: create a domain specific exception
        }

        for (int i = 0; i < category.size(); i++) {
            boolean isEquals = category.get(i).toUpperCase()
                .equals(Product.Category.values()[i].name());

            if (!isEquals) {
                var msg = String.format("Combo does not respect the category sequence. Category '%s' is repeated.",
                    category.get(i));
                throw new IllegalArgumentException(msg); //TODO: create a domain specific exception
            }
        }
    }
}
