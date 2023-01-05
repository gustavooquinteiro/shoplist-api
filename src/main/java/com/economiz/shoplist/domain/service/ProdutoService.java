package com.economiz.shoplist.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.economiz.shoplist.domain.model.Produto;
import com.economiz.shoplist.domain.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtos;
	
	public Produto salvarProduto(Produto produto) {
		return produtos.save(produto);
	}
	
	public List<Produto> listarTodos(){
		return produtos.findAll(); 
	}
	
	public Produto buscarPorId(Long id) {
		return produtos.findById(id).orElseThrow();
	}

	public Produto buscarPorNome(String nome) {
		return produtos.findByNome(nome);
	}
}
