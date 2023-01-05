package com.economiz.shoplist.api.dto;

import com.economiz.shoplist.domain.model.Mercado;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemResponseDTO {

	public ItemResponseDTO(String nome, int quantidade, Double menorValor, Mercado mercado) {
		this.nome = nome;
		this.quantidade = quantidade;
		this.valor = menorValor;
		this.mercado = mercado;
	}
	
	public ItemResponseDTO() {}
	
	private String nome;
	private int quantidade;
	private Double valor;
	private Mercado mercado;
}
