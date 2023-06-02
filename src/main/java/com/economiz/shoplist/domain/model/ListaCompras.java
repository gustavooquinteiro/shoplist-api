package com.economiz.shoplist.domain.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.economiz.shoplist.api.dto.ItemResponseDTO;
import com.economiz.shoplist.api.dto.ListaComprasResponseDTO;

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
public class ListaCompras {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany
	private List<Item> itens = new ArrayList<>();
	
	public List<Item> montarLista(){
		this.itens.stream().forEach(Item::escolherMenorValor);
		return this.itens;
	}
	
	public Double getValorTotal() {
		this.setItens(this.montarLista());
		return itens.stream()
				.mapToDouble(item -> item.getProduto().retornaValorDoMenorPreco() * item.getQuantidade())
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
