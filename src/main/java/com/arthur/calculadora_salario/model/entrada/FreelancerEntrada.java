package com.arthur.calculadora_salario.model.entrada;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class FreelancerEntrada implements FuncionarioEntrada {
    @NotNull
    private String nome;

    @NotNull
    private String tipo;

    @NotNull
    private int horasTrabalhadas;

    @NotNull
    private double valorHora;
}

