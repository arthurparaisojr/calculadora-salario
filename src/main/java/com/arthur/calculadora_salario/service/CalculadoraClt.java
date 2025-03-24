package com.arthur.calculadora_salario.service;

import com.arthur.calculadora_salario.model.FuncionarioResponse;
import com.arthur.calculadora_salario.model.entrada.CltEntrada;
import com.arthur.calculadora_salario.model.entrada.FuncionarioEntrada;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CalculadoraClt implements CalculadoraSalario {

    @Override
    public boolean aceita(String tipo) {
        return "CLT".equalsIgnoreCase(tipo);
    }

    @Override
    public FuncionarioResponse calcularSalario(FuncionarioEntrada entrada) {
        CltEntrada clt = (CltEntrada) entrada;
        double bonus = clt.getSalarioBase() * 0.10;
        double descontoINSS = clt.getSalarioBase() * 0.08;
        double salarioFinal = clt.getSalarioBase() + bonus - descontoINSS;

        return new FuncionarioResponse(clt.getNome(), "CLT",
                Map.of("salarioBase", clt.getSalarioBase(),
                        "bonus", bonus,
                        "descontoINSS", descontoINSS),
                salarioFinal);
    }
}
