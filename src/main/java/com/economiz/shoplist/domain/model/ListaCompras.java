package com.economiz.shoplist.domain.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.economiz.shoplist.api.dto.ItemResponseDTO;
import com.economiz.shoplist.api.dto.ListaComprasResponseDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class ListaCompras {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany
	private List<Item> itens = new ArrayList<>();
	
	public Double getValorTotal() {
		return itens.stream()
				.mapToDouble(Item::retornaPrecoTotal)
				.sum();
	}

	public void adicionarItem(Item item) {
		this.itens.add(item);
	}

	public ListaComprasResponseDTO toResponseDTO() {
		List<ItemResponseDTO> itensResponse = itens.stream()
				.map(Item::toItemResponse)
				.collect(Collectors.toList());
		return new ListaComprasResponseDTO(itensResponse, getValorTotal());
	}

	public void agruparPorMercado() {
		this.itens.stream().collect(
				Collectors.groupingBy(
						e -> e.getProduto().retornaMenorPreco().getMercado().getNome()));
	}
	
}
