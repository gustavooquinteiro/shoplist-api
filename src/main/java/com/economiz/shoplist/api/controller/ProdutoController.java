package com.economiz.shoplist.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.economiz.shoplist.api.dto.ProdutoDTO;
import com.economiz.shoplist.domain.model.Produto;
import com.economiz.shoplist.domain.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;
	
	@PostMapping
	public Produto cadastrarProduto(@RequestBody ProdutoDTO produtoDto) {
		Produto produto = new Produto(produtoDto);
		return produtoService.salvarProduto(produto); 
	}
}
