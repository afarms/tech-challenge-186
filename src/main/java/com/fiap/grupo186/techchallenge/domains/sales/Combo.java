package com.fiap.grupo186.techchallenge.domains.sales;


import com.fiap.grupo186.techchallenge.domains.sales.ComboType.Type;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Combo {
    private final UUID id;
    private  List<Product> burgers;
    private  List<Product> drinks;
    private  List<Product> sides;
    private  List<Product> desserts;
    private Type type;

    public Combo(
        List<Product> burgers,
        List<Product> drinks,
        List<Product> sides,
        List<Product> desserts,
        Type type
    ) {
        this.id = UUID.randomUUID();
        this.burgers = List.copyOf(burgers);
        this.drinks = List.copyOf(drinks);
        this.sides = List.copyOf(sides);
        this.desserts = List.copyOf(desserts);
        this.type = type;
        validate();
    }

    private void validate() {
        int limit = switch (this.type) {
            case SINGLE -> 1;
            case DOUBLE -> 2;
            case CUSTOMIZED -> Integer.MAX_VALUE;
        };

        if (burgers.size() > limit ||
            drinks.size() > limit ||
            sides.size() > limit ||
            desserts.size() > limit) {
            var msg = String.format("This combo does not respect the item limits for the type: %s", type);
            throw new IllegalArgumentException(msg);
        }
    }

    @Override
    public String toString() {
        return "Combo{" +
            "id=" + id +
            ", burgers=" + burgers +
            ", drinks=" + drinks +
            ", sides=" + sides +
            ", desserts=" + desserts +
            ", type=" + type +
            '}';
    }

    public UUID getId() {
        return id;
    }

    public List<Product> getBurgers() {
        return burgers;
    }

    public void setBurgers(List<Product> burgers) {
        this.burgers = burgers;
    }

    public List<Product> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<Product> drinks) {
        this.drinks = drinks;
    }

    public List<Product> getSides() {
        return sides;
    }

    public void setSides(List<Product> sides) {
        this.sides = sides;
    }

    public List<Product> getDesserts() {
        return desserts;
    }

    public void setDesserts(List<Product> desserts) {
        this.desserts = desserts;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Combo combo)) return false;
        return Objects.equals(id, combo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}