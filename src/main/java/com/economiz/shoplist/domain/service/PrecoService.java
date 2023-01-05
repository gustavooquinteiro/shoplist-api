package com.economiz.shoplist.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.economiz.shoplist.api.dto.PrecoInputDTO;
import com.economiz.shoplist.domain.model.Mercado;
import com.economiz.shoplist.domain.model.Preco;
import com.economiz.shoplist.domain.model.Produto;
import com.economiz.shoplist.domain.repository.PrecoRepository;

@Service
public class PrecoService {

	@Autowired
	private PrecoRepository precos;
	
	@Autowired
	private MercadoService mercadoService;
	
	@Autowired
	private ProdutoService produtoService;
	
	public List<Preco> listarTodos(){
		return precos.findAll();
	}
	
	public Preco salvarPreco(PrecoInputDTO preco) {
		Mercado mercado = mercadoService.buscarPorId(preco.getMercadoId());
		Produto produto = produtoService.buscarPorId(preco.getProdutoId());
		Preco precoASerSalvo = new Preco(mercado, produto, preco.getValor());
		return precos.save(precoASerSalvo);
	}
}
