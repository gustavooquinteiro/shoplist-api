package com.economiz.shoplist.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.economiz.shoplist.api.dto.ItemDTO;
import com.economiz.shoplist.domain.model.Item;
import com.economiz.shoplist.domain.model.Produto;
import com.economiz.shoplist.domain.repository.ItemRepository;
import com.economiz.shoplist.domain.repository.ProdutoRepository;

@Service
public class ItemService {

	@Autowired
	private ItemRepository itens;
	
	@Autowired
	private ProdutoRepository produtos;
	
	public Item salvarItem(ItemDTO item) {
		Produto produto = produtos.findByNome(item.getNome());
		Item itemASerSalvo = new Item(produto, item.getQuantidade());
		return itens.save(itemASerSalvo);
	}
	
	public Item buscarPorId(Long id) {
		return itens.findById(id).orElseThrow();
	}

	public Item buscarPorNome(String nome) {
		Produto p = produtos.findByNome(nome);
		return itens.findByProdutoId(p.getId());
	}
}
