package com.fiap.grupo186.techchallenge.domains.sales;

import java.math.BigDecimal;
import java.util.List;

public class Rafael {
    public static void main(String[] args) {
        var bigDecimalList = List.of(BigDecimal.ONE, BigDecimal.TWO, BigDecimal.ONE, BigDecimal.TEN);

        var price = bigDecimalList.stream()
            .filter(value -> value.compareTo(BigDecimal.ONE) > 0)
            .reduce(BigDecimal.ZERO, BigDecimal::add);

        System.out.println("Total Price: " + price);
    }
}
