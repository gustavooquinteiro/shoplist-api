package com.economiz.shoplist.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.economiz.shoplist.domain.model.ListaCompras;
import com.economiz.shoplist.domain.repository.ListaComprasRepository;

@Service
public class ListaComprasService {

	@Autowired
	private ListaComprasRepository listaComprasRepository;
	
	public ListaCompras salvarListaCompras(ListaCompras listaCompras) {
		return listaComprasRepository.save(listaCompras);
	}
	
	public ListaCompras buscarPorId(Long id) {
		return listaComprasRepository.findById(id).orElseThrow();
	}
	
	public void removerListaCompras(Long id) {
		ListaCompras lista = buscarPorId(id);
		listaComprasRepository.delete(lista);
	}
}
