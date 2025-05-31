package com.fiap.grupo186.techchallenge.infrastructure.config.controller;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Parameter(
    description = "Product category",
    schema = @Schema(type = "string", allowableValues = { "BURGER", "SIDE", "DRINK", "DESSERT" })
)
public @interface CategoryParameter {
}
