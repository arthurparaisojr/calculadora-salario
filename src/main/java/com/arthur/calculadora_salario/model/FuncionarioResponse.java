package com.arthur.calculadora_salario.model;

import lombok.Data;

import java.util.Map;

@Data
public class FuncionarioResponse {
    private String nome;
    private String tipo;
    private Map<String, Object> detalhes;
    private double salarioFinal;

    public FuncionarioResponse(String nome, String tipo, Map<String, Object> detalhes, double salarioFinal) {
        this.nome = nome;
        this.tipo = tipo;
        this.detalhes = detalhes;
        this.salarioFinal = salarioFinal;
    }
}
