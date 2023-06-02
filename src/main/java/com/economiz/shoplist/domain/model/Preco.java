package com.economiz.shoplist.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
