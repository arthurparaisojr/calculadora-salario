package com.arthur.calculadora_salario.exception;

public class TipoFuncionarioInvalidoException extends RuntimeException {
    public TipoFuncionarioInvalidoException(String tipo) {
        super("Tipo de funcionário inválido: " + tipo);
    }
}
