package com.arthur.calculadora_salario.model.entrada;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CltEntrada implements FuncionarioEntrada {
    @NotNull
    private String nome;
    @NotNull
    private String tipo;
    @NotNull
    private double salarioBase;

    @Override
    public String getNome() { return nome; }

    @Override
    public String getTipo() { return tipo; }

    public double getSalarioBase() { return salarioBase; }
    public void setSalarioBase(double salarioBase) { this.salarioBase = salarioBase; }
}
