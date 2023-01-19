package com.economiz.shoplist.api.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.economiz.shoplist.domain.model.Mercado;
import com.economiz.shoplist.domain.service.MercadoService;

@RestController
@RequestMapping("/mercados")
public class MercadoController {

	@Autowired
	private MercadoService mercadoService;
	
	@GetMapping
	public List<Mercado> listarMercados(){
		return mercadoService.listarTodos();
	}
	
	@PostMapping
	public Mercado cadastrarMercado(@RequestBody Mercado mercado) {
		return mercadoService.salvarMercado(mercado);
	}
	
	@PostMapping("/{idMercado}")
	public Mercado atualizarMercado(@PathVariable Long idMercado, @RequestBody Mercado mercado) {
		Mercado mercadoASerAtualizado = mercadoService.buscarPorId(idMercado);
		BeanUtils.copyProperties(mercado, mercadoASerAtualizado, "id");
		mercadoASerAtualizado = mercadoService.salvarMercado(mercadoASerAtualizado);
		return mercadoASerAtualizado; 
	}
	
	@DeleteMapping("/{idMercado}")
	public void removerMercado(@PathVariable Long idMercado) {
		mercadoService.removerMercado(idMercado);
	}
}
