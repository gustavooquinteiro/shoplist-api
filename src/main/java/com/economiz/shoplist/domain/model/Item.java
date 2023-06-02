package com.economiz.shoplist.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.economiz.shoplist.api.dto.ItemResponseDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Item {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	private Produto produto;
		
	private int quantidade;
	
	public Item(Produto produto, int quantidade) {
		this.produto = produto;
		this.quantidade = quantidade;
	}
	
	public Item() {}

	public ItemResponseDTO toItemResponse() {
		this.escolherMenorValor();
		return new ItemResponseDTO(produto.getNome(), 
									quantidade, 
									produto.retornaValorDoMenorPreco(), 
									produto.retornaMenorPreco().getMercado());
	}
	
	public void escolherMenorValor() {
		this.produto.ordenarPrecos();
	}
}
