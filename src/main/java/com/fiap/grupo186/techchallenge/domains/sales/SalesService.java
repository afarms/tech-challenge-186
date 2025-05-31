package com.fiap.grupo186.techchallenge.domains.sales;

public class SalesService {
    public void validate(Combo combo) {
        int limit = switch (combo.getType()) {
            case SINGLE -> 1;
            case DOUBLE -> 2;
            case CUSTOMIZED -> Integer.MAX_VALUE;
        };

        if (combo.getBurgers().size() > limit ||
            combo.getDrinks().size() > limit ||
            combo.getSides().size() > limit ||
            combo.getDesserts().size() > limit) {

            var msg = String.format("Combo '%s' does not respect the item limits for the type: %s",
                combo.getId(), combo.getType());
            throw new IllegalArgumentException(msg);
        }
    }
}
