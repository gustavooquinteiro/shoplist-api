package com.economiz.shoplist.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.economiz.shoplist.api.dto.ItemDTO;
import com.economiz.shoplist.api.dto.ListaComprasResponseDTO;
import com.economiz.shoplist.domain.model.Item;
import com.economiz.shoplist.domain.model.ListaCompras;
import com.economiz.shoplist.domain.service.ItemService;
import com.economiz.shoplist.domain.service.ListaComprasService;

@RestController
@RequestMapping("/lista")
public class ListaComprasController {

	@Autowired
	private ListaComprasService listaComprasService;
	
	@Autowired
	private ItemService itemService;
	 
	@PostMapping
	public ListaCompras cadastrarLista() {
		return listaComprasService.salvarListaCompras(new ListaCompras());
	}
	
	@PostMapping("/{idLista}")
	public ListaCompras adicionarItem(@PathVariable Long idLista, @RequestBody ItemDTO item) {
		ListaCompras lista = listaComprasService.buscarPorId(idLista);
		Item itemSalvo = itemService.buscarPorNome(item.getNome());
		if (!lista.getItens().contains(itemSalvo)) {
			Item itemASerSalvo = itemService.salvarItem(item);
			lista.adicionarItem(itemASerSalvo);
		} else {
			itemSalvo.setQuantidade(item.getQuantidade());
			lista.getItens().add(lista.getItens().lastIndexOf(itemSalvo), itemSalvo);
		}
		return listaComprasService.salvarListaCompras(lista);
	}
	
	@GetMapping("/{idLista}")
	public ListaComprasResponseDTO verLista(@PathVariable Long idLista) {
		ListaCompras lista = listaComprasService.buscarPorId(idLista);
		return lista.toResponseDTO();
	}
	
}
