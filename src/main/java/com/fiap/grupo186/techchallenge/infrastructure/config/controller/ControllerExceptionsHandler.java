package com.fiap.grupo186.techchallenge.infrastructure.config.controller;

import com.fiap.grupo186.techchallenge.domains.kitchen.services.InvalidStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.stream.Collectors;

import static java.lang.String.format;

@RestControllerAdvice
public class ControllerExceptionsHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ProblemDetail> handleValidation(MethodArgumentNotValidException ex) {
        ProblemDetail pd = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);

        var fildErroList = ex.getBindingResult().getFieldErrors();

        String errors = fildErroList.isEmpty() ? "Not found fields errors to show." :
                fildErroList.stream()
                        .map(f -> format("%s: %s", f.getField(), f.getDefaultMessage()))
                        .collect(Collectors.joining("; "));

        pd.setDetail(errors);
        return ResponseEntity.badRequest().body(pd);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ProblemDetail> handleIllegalArgumentException(IllegalArgumentException ex) {
        ProblemDetail pd = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        pd.setDetail(ex.getMessage());
        return ResponseEntity.badRequest().body(pd);
    }

    @ExceptionHandler(InvalidStatusException.class)
    public ResponseEntity<ProblemDetail> handleInvalidStatusException(InvalidStatusException ex) {
        ProblemDetail pd = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);

        pd.setTitle("Invalid update Status");
        pd.setDetail(ex.getMessage());
        pd.setProperty("timestamp", Instant.now());

        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(pd);
    }
}
