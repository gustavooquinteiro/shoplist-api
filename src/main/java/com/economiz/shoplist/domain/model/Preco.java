package com.economiz.shoplist.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@Entity
public class Preco implements Comparable<Preco>{

	public Preco(Mercado mercado, Produto produto, Double valor) {
		this.mercado = mercado;
		this.produto = produto;
		this.valor = valor;
	}
	
	public Preco() {}

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private Long id;
	
	@OneToOne
	private Mercado mercado;
	
	@OneToOne
	@JsonIgnore
	private Produto produto;
	
	private Double valor;

	@Override
	public int compareTo(Preco o) {
		return this.valor.compareTo(o.getValor());
	}
	
}
