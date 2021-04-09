package com.smartbr.snichelotto.domain.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.smartbr.snichelotto.domain.exception.EntidadeNaoEncontradaException;
import com.smartbr.snichelotto.domain.exception.NegocioException;
import com.smartbr.snichelotto.domain.model.Cliente;
import com.smartbr.snichelotto.domain.model.Produto;

import com.smartbr.snichelotto.domain.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	// SALVAR CADASTRO CLIENTE

	public Produto salvar(Produto produto) {
		Produto produtoExistente = produtoRepository.findByNome(produto.getNome());
		if (produtoExistente != null && !produtoExistente.equals(produto)) {
			throw new NegocioException("Esse produto já está cadastrado!");
		}
		return produtoRepository.save(produto);
	}

	// ADICIONAR NOVO PRODUTO

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Produto adicionar(@Valid @PathVariable Produto produto) {
		return produtoRepository.save(produto);

	}

	// EXCLUIR PRODUTO

 	public void excluir(Long produtoId) {
		Produto produto = produtoRepository.findById(produtoId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException("Produto não encontrado"));
		produtoRepository.deleteById(produtoId);

	} 

	// LISTAR

	@GetMapping
	public List<Produto> listar() {
		return (List<Produto>) produtoRepository.findAll();
	}

	// BUSCAR

	private Produto buscar(Long produtoId) {
		Produto produto = produtoRepository.findById(produtoId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException("Produto não encontrado"));
		return produto;
	}

	// FINALIZAR

	public void finalizar(Long produtoId) {
		Produto produto = buscar(produtoId);
		produto.finalizar();

		produtoRepository.save(produto);
	}

	// METHOD

	public Optional<Produto> findById(Long produtoId) {
		return null;
	}

	public Produto criar(@Valid Produto produto) {
		return null;
	}

}
