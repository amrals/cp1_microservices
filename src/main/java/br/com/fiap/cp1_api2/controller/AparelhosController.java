package br.com.fiap.cp1_api2.controller;

import br.com.fiap.cp1_api2.model.Aparelho;
import br.com.fiap.cp1_api2.repository.AparelhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("aparelhos")
public class AparelhosController {

    @Autowired
    private AparelhoRepository repository;

    @GetMapping
    public ResponseEntity<List<Aparelho>> getAparelhos() {
        var aparelhos = repository.findAll();
        return ResponseEntity.ok(aparelhos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aparelho> buscarPorId(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Aparelho> criar(@RequestBody Aparelho aparelho) {
        Aparelho novo = repository.save(aparelho);
        return ResponseEntity.status(HttpStatus.CREATED).body(novo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aparelho> atualizar(@PathVariable Long id,
                                              @RequestBody Aparelho aparelho) {
        return repository.findById(id)
                .map(a -> {
                    a.setNmAparelho(aparelho.getNmAparelho());
                    a.setVlAparelho(aparelho.getVlAparelho());
                    a.setMarca(aparelho.getMarca());
                    a.setCor(aparelho.getCor());

                    Aparelho atualizado = repository.save(a);
                    return ResponseEntity.ok(atualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        Optional<Aparelho> aparelho = repository.findById(id);

        if (aparelho.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        repository.delete(aparelho.get());
        return ResponseEntity.noContent().build();
    }
}
