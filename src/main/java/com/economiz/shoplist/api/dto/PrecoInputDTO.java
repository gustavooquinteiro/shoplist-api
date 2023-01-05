package com.economiz.shoplist.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PrecoInputDTO {

	private Double valor;
	
	private Long mercadoId;
	
	private Long produtoId;
}
