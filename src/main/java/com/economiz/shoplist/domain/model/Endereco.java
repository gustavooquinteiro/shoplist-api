package com.economiz.shoplist.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
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
