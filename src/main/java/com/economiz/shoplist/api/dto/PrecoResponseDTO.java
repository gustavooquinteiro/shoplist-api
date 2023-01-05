package com.economiz.shoplist.api.dto;

import com.economiz.shoplist.domain.model.Mercado;
import com.economiz.shoplist.domain.model.Preco;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PrecoResponseDTO {

	public PrecoResponseDTO(Preco preco) {
		this.mercado = preco.getMercado();
		this.nomeProduto = preco.getProduto().getNome();
		this.valor = preco.getValor();
	}
	
	public PrecoResponseDTO() {}
	
	private String nomeProduto;
	private Mercado mercado;
	private Double valor;
	
}
