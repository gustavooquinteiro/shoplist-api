package com.economiz.shoplist.domain.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class ItemTest {

	static Mercado mercadoDefault = new Mercado();
	static Produto produto = new Produto();
	
	@BeforeAll
	public static void setUp() {
		for (int i = 3; i < 20; i++) {
			produto.adicionarPreco(new Preco(mercadoDefault, produto, (double) i + Math.random()));
		}
	}
	

	@Test
	public void deveCalcularOPrecoTotalDeUmProduto() {
		Item item = new Item(produto, 10);
		Double expected = produto.getPrecos().get(0).getValor() * item.getQuantidade();
		assertEquals(expected, item.retornaPrecoTotal());
	}
}
