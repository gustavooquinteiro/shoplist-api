package com.economiz.shoplist.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.economiz.shoplist.domain.model.Mercado;
import com.economiz.shoplist.domain.repository.MercadoRepository;

@Service
public class MercadoService {

	@Autowired
	private MercadoRepository mercados;
	
	public List<Mercado> listarTodos(){
		return mercados.findAll();
	}
	
	public Mercado buscarPorId(Long id) {
		return mercados.findById(id).orElseThrow();
	}

	public Mercado salvarMercado(Mercado mercado) {
		return mercados.save(mercado);
	}
	
	public void removerMercado(Long idMercado) {
		Mercado mercado = buscarPorId(idMercado);
		mercados.delete(mercado);
	}
}
