package com.arthur.calculadora_salario.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class ValidacaoExceptionHandler {

    @ExceptionHandler(TipoFuncionarioInvalidoException.class)
    public ResponseEntity<?> handleTipoInvalido(TipoFuncionarioInvalidoException ex) {
        return ResponseEntity.badRequest().body(Map.of("erro", ex.getMessage()));
    }
}
