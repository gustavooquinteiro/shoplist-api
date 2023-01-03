package com.economiz.shoplist.domain.model;

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
public class Preco {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	private Mercado mercado;
	
	@OneToOne
	private Produto produto;
	
	private Double valor;
	
}
