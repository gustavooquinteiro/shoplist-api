package com.economiz.shoplist.domain.model;

import com.economiz.shoplist.api.dto.ItemResponseDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
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
	
	private Double menorValor;
	
	private int quantidade;
	
	public void escolherMenorValor() {
		Double preco = produto.getPrecos().stream().min((o1, o2) -> o1.compareTo(o2)).get().getValor();
		System.out.println(preco);
		this.setMenorValor(preco);
	}

	public Item(Produto produto, int quantidade) {
		this.produto = produto;
		this.escolherMenorValor();
		this.quantidade = quantidade;
	}
	
	public Item() {}

	public ItemResponseDTO toItemResponse() {
		escolherMenorValor();
		return new ItemResponseDTO(produto.getNome(), 
									quantidade, 
									menorValor, 
									produto.getPrecos().get(0).getMercado());
	}
}
