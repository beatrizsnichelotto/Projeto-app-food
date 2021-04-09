package com.smartbr.snichelotto.api.model;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import com.smartbr.snichelotto.domain.enums.EnumTipoProduto;

public class ProdutoIdInput {

	@NotBlank
	private String nome;

	@NotNull
	private BigDecimal valor;

	@Valid
	@NotNull
	private ClienteIdInput cliente;

	private EnumTipoProduto produto;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public ClienteIdInput getCliente() {
		return cliente;
	}

	public void setCliente(ClienteIdInput cliente) {
		this.cliente = cliente;
	}

	public EnumTipoProduto getProduto() {
		return produto;
	}

	public void setProduto(EnumTipoProduto produto) {
		this.produto = produto;
	}

	
	
}
