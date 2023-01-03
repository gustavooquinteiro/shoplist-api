package com.economiz.shoplist.domain.model;

import java.util.ArrayList;
import java.util.List;

import com.economiz.shoplist.api.dto.ProdutoDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Produto {

	public Produto(ProdutoDTO produtoDto) {
		this.nome = produtoDto.getNome();
		this.precos = new ArrayList<>();
	}

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String nome;
	
	@OneToMany
	private List<Preco> precos = new ArrayList<>();
}
