package com.smartbr.snichelotto.domain.enums;

public enum EnumTipoProduto {

	COMIDA("Comida"), BEBIDA("Bebida");

	EnumTipoProduto(String descricao) {
		this.descricao = descricao;
	}

	private String descricao;

	public String getDestricao() {
		return descricao;

	}

	@Override
	public String toString() {
		return this.descricao;

	}
}
