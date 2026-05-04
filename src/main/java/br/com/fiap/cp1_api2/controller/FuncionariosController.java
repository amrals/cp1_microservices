package br.com.fiap.cp1_api2.controller;

import br.com.fiap.cp1_api2.model.Funcionario;
import br.com.fiap.cp1_api2.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("funcionarios")
public class FuncionariosController {

    @Autowired
    private FuncionarioRepository repository;

    @GetMapping
    public ResponseEntity<List<Funcionario>> getFuncionarios() {
        var funcionarios = repository.findAll();
        return ResponseEntity.ok(funcionarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> buscarPorId(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Funcionario> criar(@RequestBody Funcionario funcionario) {
        Funcionario novo = repository.save(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED).body(novo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> atualizar(@PathVariable Long id,
                                                 @RequestBody Funcionario funcionario) {
        return repository.findById(id)
                .map(f -> {
                    f.setNmFuncionario(funcionario.getNmFuncionario());
                    f.setFuncao(funcionario.getFuncao());
                    f.setDtAdmissao(funcionario.getDtAdmissao());
                    f.setDtDemissao(funcionario.getDtDemissao());

                    Funcionario atualizado = repository.save(f);
                    return ResponseEntity.ok(atualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        Optional<Funcionario> funcionario = repository.findById(id);

        if (funcionario.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        repository.delete(funcionario.get());
        return ResponseEntity.noContent().build();
    }
}
