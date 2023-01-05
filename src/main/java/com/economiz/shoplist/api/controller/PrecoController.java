package com.economiz.shoplist.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.economiz.shoplist.api.dto.PrecoInputDTO;
import com.economiz.shoplist.api.dto.PrecoResponseDTO;
import com.economiz.shoplist.domain.model.Preco;
import com.economiz.shoplist.domain.model.Produto;
import com.economiz.shoplist.domain.service.PrecoService;
import com.economiz.shoplist.domain.service.ProdutoService;

@RestController
@RequestMapping("/precos")
public class PrecoController {

	@Autowired
	private PrecoService precoService;
	
	@Autowired
	private ProdutoService produtoService;
	
	@PostMapping
	public PrecoResponseDTO cadastrarPreco (@RequestBody PrecoInputDTO preco) {
		Preco precoSalvo = precoService.salvarPreco(preco);
		atualizarPrecoNoProduto(precoSalvo, preco.getProdutoId());
		PrecoResponseDTO response = new PrecoResponseDTO(precoSalvo);
		return response;
	}

	private void atualizarPrecoNoProduto(Preco precoSalvo, Long produtoId) {
		Produto produto = produtoService.buscarPorId(produtoId);
		produto.adicionarPreco(precoSalvo);
		produtoService.salvarProduto(produto);
	}
	
	
}
