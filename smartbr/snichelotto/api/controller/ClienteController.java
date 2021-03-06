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

import com.smartbr.snichelotto.domain.model.Cliente;
import com.smartbr.snichelotto.domain.repository.ClienteRepository;
import com.smartbr.snichelotto.domain.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private ClienteRepository clienteRepository;

	// ADICIONAR CLIENTE

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente adicionar(@Valid @RequestBody Cliente cliente) {
		return clienteService.salvar(cliente);

	}

	// LISTAR CLIENTES

	@GetMapping
	public List<Cliente> listar() {
		return (List<Cliente>) clienteService.listar();
	}

	// BUSCAR CLIENTES

	@GetMapping("/{clienteId}")
	public ResponseEntity<Cliente> buscar(@Valid @PathVariable Long clienteId) {
		Optional<Cliente> cliente = clienteService.buscarPorId(clienteId);

		if (cliente.isPresent()) {
			return ResponseEntity.ok(cliente.get());
		}
		return ResponseEntity.notFound().build();
	}

	// ATUALIZAR CLIENTE

	@PutMapping("/{clienteId}")
	public ResponseEntity<Cliente> atualizar(@Valid @PathVariable Long clienteId, @RequestBody Cliente cliente) {

		if (!clienteRepository.existsById(clienteId)) {
			return ResponseEntity.notFound().build();
		}
		cliente.setId(clienteId);
		clienteService.salvar(cliente);
		return ResponseEntity.ok(cliente);
	}

	// EXCLUIR CLIENTE

	@DeleteMapping("/{clienteId}")
	public ResponseEntity<Void> remover(@PathVariable Long clienteId) {
		if (!clienteRepository.existsById(clienteId)) {
			return ResponseEntity.notFound().build();
		}

		clienteService.excluir(clienteId);

		return ResponseEntity.noContent().build();

	}
}
