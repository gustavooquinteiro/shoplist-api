package com.economiz.shoplist.domain.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import com.economiz.shoplist.api.dto.ProdutoDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	public Produto() {
		this.nome = "";
		this.precos = new ArrayList<>();
	}

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private Long id;
	
	@Column
	@NotBlank
	private String nome;
	
	@OneToMany
	private List<Preco> precos = new ArrayList<>();
	
	public void adicionarPreco(Preco preco) {
		this.precos.add(preco);
		this.ordenarPrecos();
	}
	
	public void ordenarPrecos() {
		this.getPrecos().stream().min((o1, o2) -> o1.compareTo(o2)).get();
	}
	
	public Double retornaValorDoMenorPreco() {
		return this.retornaMenorPreco().getValor();
	}
	
	public Preco retornaMenorPreco() {
		this.ordenarPrecos();
		return this.precos.get(0);
	}
	
}
