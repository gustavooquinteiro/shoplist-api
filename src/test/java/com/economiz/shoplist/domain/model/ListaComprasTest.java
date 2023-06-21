package com.economiz.shoplist.domain.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class ListaComprasTest {

	static Mercado mercadoDefault = new Mercado();
	static Produto produto1 = new Produto();
	static Produto produto2 = new Produto();
	static Produto produto3 = new Produto();
	static Item item1;
	static Item item2;
	static Item item3;
	ListaCompras lista = new ListaCompras();
	
	@BeforeAll
	public static void setUp() {
		for (int i = 3; i < 20; i++) {
			produto1.adicionarPreco(new Preco(mercadoDefault, produto1, (double) i + Math.random()));
			produto2.adicionarPreco(new Preco(mercadoDefault, produto2, (double) i + Math.random()));
			produto3.adicionarPreco(new Preco(mercadoDefault, produto3, (double) i + Math.random()));
		}
		item1 = new Item(produto1, 10);
		item2 = new Item(produto2, 10);
		item3 = new Item(produto3, 10);
	}
	

	@Test
	public void deveRetornarOValorTotalDaListaCorretamente() {
		List.of(item1, item2, item3).forEach(item -> {
			lista.adicionarItem(item);
		});
		Double total = List.of(item1.retornaPrecoTotal(), 
								item2.retornaPrecoTotal(), 
								item3.retornaPrecoTotal())
						.stream()
						.mapToDouble(Double::doubleValue)
						.sum();
		assertEquals(total, lista.getValorTotal());
	
	}
}
