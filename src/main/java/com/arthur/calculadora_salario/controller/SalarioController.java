package com.arthur.calculadora_salario.controller;

import com.arthur.calculadora_salario.model.FuncionarioResponse;
import com.arthur.calculadora_salario.service.SalarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/calcular-salario")
public class SalarioController {

    @Autowired
    private SalarioService salarioService;

    @PostMapping
    public FuncionarioResponse calcularSalario(@RequestBody Map<String, Object> payload) {
        return salarioService.calcular(payload);
    }
}

