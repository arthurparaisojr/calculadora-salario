package com.arthur.calculadora_salario.service;

import com.arthur.calculadora_salario.model.FuncionarioResponse;
import com.arthur.calculadora_salario.model.entrada.FuncionarioEntrada;

public interface CalculadoraSalario {
    boolean aceita(String tipo);
    FuncionarioResponse calcularSalario(FuncionarioEntrada entrada);
}
