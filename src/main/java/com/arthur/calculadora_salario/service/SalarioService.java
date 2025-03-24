package com.arthur.calculadora_salario.service;

import com.arthur.calculadora_salario.exception.TipoFuncionarioInvalidoException;
import com.arthur.calculadora_salario.model.FuncionarioResponse;
import com.arthur.calculadora_salario.model.entrada.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SalarioService {

    @Autowired
    private List<CalculadoraSalario> calculadoras;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public FuncionarioResponse calcular(Map<String, Object> json) {
        String tipo = (String) json.get("tipo");
        CalculadoraSalario calculadora = calculadoras.stream()
                .filter(c -> c.aceita(tipo))
                .findFirst()
                .orElseThrow(() -> new TipoFuncionarioInvalidoException(tipo));

        FuncionarioEntrada entrada = mapearEntrada(json, tipo);
        return calculadora.calcularSalario(entrada);
    }

    private FuncionarioEntrada mapearEntrada(Map<String, Object> json, String tipo) {
        return switch (tipo.toUpperCase()) {
            case "CLT" -> objectMapper.convertValue(json, CltEntrada.class);
            case "PJ" -> objectMapper.convertValue(json, PjEntrada.class);
            case "FREELANCER" -> objectMapper.convertValue(json, FreelancerEntrada.class);
            case "ESTAGIARIO" -> objectMapper.convertValue(json, EstagiarioEntrada.class);
            default -> throw new TipoFuncionarioInvalidoException(tipo);
        };
    }
}
