package com.fiap.grupo186.techchallenge.domains.kitchen.services;

public class InvalidStatusException extends RuntimeException {
    public InvalidStatusException(String message) {
        super(message);
    }
}
