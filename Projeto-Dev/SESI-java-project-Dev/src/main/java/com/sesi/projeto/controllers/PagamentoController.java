package com.sesi.projeto.controllers;

import com.sesi.projeto.entities.Pagamento;
import com.sesi.projeto.repositories.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("pagamento")
public class PagamentoController {

    @Autowired
    PagamentoRepository repo;

    @GetMapping
    public ResponseEntity<List<Pagamento>> listarTodos() {
        return ResponseEntity.ok(repo.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        Optional<Pagamento> pagamento = repo.findById(id);
        return pagamento.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Pagamento> criar(@RequestBody Pagamento pagamento) {
        return ResponseEntity.ok(repo.save(pagamento));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody Pagamento pagamento) {
        if (repo.existsById(id)) {
            pagamento.setId(id);
            return ResponseEntity.ok(repo.save(pagamento));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
