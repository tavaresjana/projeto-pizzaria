package com.projetopizzaria.handler;

import com.projetopizzaria.handler.exceptions.CampoVazioException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(CampoVazioException.class)
    public ResponseEntity<StandardError> CampoVazioException(CampoVazioException campoVazioException) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        StandardError standardError = new StandardError(Instant.now(), httpStatus.value(), campoVazioException.getMessage());
        return ResponseEntity.status(httpStatus).body(standardError);
    }
}
