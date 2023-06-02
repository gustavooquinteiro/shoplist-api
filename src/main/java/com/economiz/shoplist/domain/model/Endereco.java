package com.economiz.shoplist.domain.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class Endereco {

	@Column
	private String cep;
	@Column
	private String bairro;
	@Column
	private String logradouro;
	@Column
	private String cidade;
	@Column
	private String complemento;

}
