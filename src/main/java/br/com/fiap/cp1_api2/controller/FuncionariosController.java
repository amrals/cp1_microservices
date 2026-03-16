package br.com.fiap.cp1_api2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("funcionarios")
public class FuncionariosController {
    @GetMapping()
    public String GetFuncionarios() {
        return "Matheus, Anaí, David, Kauan";
    }

    @GetMapping("funcionarioDoMes")
    public String GetFuncionarioDoMes() {
        return "Matheus";
    }
}
