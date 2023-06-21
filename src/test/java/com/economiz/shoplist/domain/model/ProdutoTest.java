package com.economiz.shoplist.domain.model;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class ProdutoTest {

	static Mercado mercadoDefault = new Mercado();
	static Produto produto = new Produto();
	private static List<Preco> precosJaOrdenados = new ArrayList<>();
	private static List<Preco> precosDesordenados = new ArrayList<>();
	
	@BeforeAll
	public static void setUp() {
		for (int i = 3; i < 20; i++) {
			precosJaOrdenados.add(new Preco(mercadoDefault, produto, (double) i));
		}
		for (int i = 3; i < 20; i++) {
			precosDesordenados.add(new Preco(mercadoDefault, produto, (double) i + Math.random()));
		}
	}
	
	@Test
	public void deveAdicionarPrecosJaOrdenadosEManterAOrdem() {
		for (Preco preco: precosJaOrdenados) {
			produto.adicionarPreco(preco);
		}
		assertArrayEquals(precosJaOrdenados.toArray(), produto.getPrecos().toArray());
	}
	
	@Test
	public void deveAdicionarPrecosEOrdenar() {
		Produto produto1 = new Produto();
		for (Preco preco: precosDesordenados) {
			produto1.adicionarPreco(preco);
		}
		precosDesordenados.sort(Preco::compareTo);
		assertArrayEquals(precosDesordenados.toArray(), produto1.getPrecos().toArray());
	}
	
	@Test
	public void deveRetornarOMenorPreco() {
		assertEquals(produto.retornaMenorPreco(), precosJaOrdenados.get(0));
	}
	
	@Test
	public void deveRetornarOValorDoMenorPreco() {
		assertEquals(produto.retornaValorDoMenorPreco(), precosJaOrdenados.get(0).getValor());
	}
	
}
