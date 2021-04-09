package com.smartbr.snichelotto.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartbr.snichelotto.api.validaCpf.ValidaCpf;
import com.smartbr.snichelotto.domain.exception.EntidadeNaoEncontradaException;
import com.smartbr.snichelotto.domain.exception.NegocioException;
import com.smartbr.snichelotto.domain.model.Cliente;
import com.smartbr.snichelotto.domain.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	private Cliente cliente;

	// SALVAR CADASTRO CLIENTE

	public Cliente salvar(Cliente cliente) {
		Cliente clienteExistente = clienteRepository.findByCpf(cliente.getCpf());
		if (clienteExistente != null && !clienteExistente.equals(cliente)) {
			throw new NegocioException("Esse CPF já está cadastrado. Utilize outro CPF para novo Cadastro!");

		}
		if (ValidaCpf.isCPF(cliente.getCpf()) == false) {
			throw new NegocioException("Esse CPF não é válido! Insira um CPF válido!");
		}
		
		return clienteRepository.save(cliente);

	}

	// EXCLUIR CLIENTE

 	public void excluir(Long clienteId) {
		Cliente cliente = clienteRepository.findById(clienteId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException("Cliente não encontrado"));
		clienteRepository.deleteById(clienteId);

	} 

	// LISTAR

	public List<Cliente> listar() {
		return (List<Cliente>) clienteRepository.findAll();

	}

	// BUSCAR

	public Optional<Cliente> buscarPorId(Long clienteId) {
		return clienteRepository.findById(clienteId);
	}

	// ADICIONAR CLIENTE

	public Cliente adicionar(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	// ATUALIZAR CLIENTE

	public void atualizar(Long clienteId) {
		clienteRepository.save(cliente);
	}

	// EXCLUIR PRODUTOS DO CLIENTE

/*	private void deletaProdutoDoCliente(Cliente cliente) {
		List<Produto> produtos = produtoRepository.findAllByCliente(cliente);
		for (Produto produto : produtos) {
			if (clienteTemProdutoAberto(produto)) {
				throw new NegocioException("Essa pessoa ainda tem contas em aberto, você não pode exclui-la");
			}
			produtoRepository.delete(produto);
		}
	}

	public boolean clienteTemProdutoAberto(Produto produto) {
		if (produto.getStatus().equals(EnumStatus.ABERTA)) {
			return true;
		}
		return false;
	} */

}
