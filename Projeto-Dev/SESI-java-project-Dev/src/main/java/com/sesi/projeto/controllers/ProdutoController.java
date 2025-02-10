package com.sesi.projeto.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sesi.projeto.dto.ProdutoDTO;
import com.sesi.projeto.entities.Produto;
import com.sesi.projeto.repositories.ProdutoRepository;

@RestController
@RequestMapping("produto")
public class ProdutoController {

	@Autowired
	ProdutoRepository repo;

	@GetMapping
	public ResponseEntity<List<Produto>> mostrarTodos() {
		List<Produto> prod = repo.findAll();
		return ResponseEntity.ok(prod);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> mostrarPorId(@PathVariable Long id) {
		Produto prod = repo.getById(id);
		return ResponseEntity.ok(prod);
	}

	@PostMapping
	public ResponseEntity<Produto> criar(@RequestBody ProdutoDTO dto){
		Produto prod = new Produto(dto);
		return ResponseEntity.ok(prod);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody ProdutoDTO dto) {
		Optional<Produto> produtoExistente = repo.findById(id);

		if (produtoExistente.isPresent()) {
			Produto produto = produtoExistente.get();
			produto.setNome(dto.nome());
			produto.setPreco(dto.preco());
			produto.setDescricao(dto.descricao());
			produto.setImgUrl(dto.imgUrl());

			repo.save(produto);
			return ResponseEntity.ok(produto);
		} else {
			return ResponseEntity.notFound().build();
		}
	}


	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deletar(@PathVariable Long id) {
		if (repo.existsById(id)) {
			repo.deleteById(id);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	}



