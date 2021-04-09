package com.smartbr.snichelotto.api.model;

import java.math.BigDecimal;
import java.util.Date;

import com.smartbr.snichelotto.domain.enums.EnumTipoProduto;
import com.smartbr.snichelotto.domain.model.Cliente;

public class ProdutoResumoModel {

	private BigDecimal valor;
	private String nome;
	private Cliente cliente;
	private EnumTipoProduto tipo;

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public EnumTipoProduto getTipo() {
		return tipo;
	}

	public void setTipo(EnumTipoProduto tipo) {
		this.tipo = tipo;

	}

}
