package com.smartbr.snichelotto.api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.smartbr.snichelotto.domain.model.Produto;
import com.smartbr.snichelotto.domain.repository.ProdutoRepository;
import com.smartbr.snichelotto.domain.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@Autowired
	private ProdutoRepository produtoRepository;

	// LISTAS

	@GetMapping
	public List<Produto> listar() {
		return (List<Produto>) produtoRepository.findAll();
	}

	// BUSCAR PRODUTO

	@GetMapping("{produtoId}")
	public ResponseEntity<Produto> buscar(@PathVariable Long produtoId) {
		Optional<Produto> produto = produtoService.findById(produtoId);

		if (produto.isPresent()) {
			return ResponseEntity.ok(produto.get());
		}
		return ResponseEntity.notFound().build();
	}

	// ADICIONAR PRODUTO

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Produto adicionar(@Valid @PathVariable Produto produto) {
		return produtoService.criar(produto);
	}

	// ATUALIZAR PRODUTOS

	@PutMapping("/{produtoId}")
	public ResponseEntity<Produto> atualizar(@Valid @PathVariable Long produtoId, @RequestBody Produto produto) {

		if (!produtoRepository.existsById(produtoId)) {
			return ResponseEntity.notFound().build();

		}
		produto.setId(produtoId);
		produto = produtoService.criar(produto);

		return ResponseEntity.ok(produto);
	}

	// EXCLUIR PRODUTIO

		@DeleteMapping("/{produtoId}")
		public ResponseEntity<Void> remover(@PathVariable Long produtoId) {
			if (!produtoRepository.existsById(produtoId)) {
				return ResponseEntity.notFound().build();
			}

			produtoService.excluir(produtoId);

			return ResponseEntity.noContent().build();

		}

}
