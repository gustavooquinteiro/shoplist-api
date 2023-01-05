package com.economiz.shoplist.api.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListaComprasResponseDTO {

	public ListaComprasResponseDTO(List<ItemResponseDTO> itens, Double valorTotal) {
		this.itens = itens;
		this.total = valorTotal;
	}
	
	public ListaComprasResponseDTO() {}
	
	private List<ItemResponseDTO> itens = new ArrayList<>();
	private Double total;
	
}
