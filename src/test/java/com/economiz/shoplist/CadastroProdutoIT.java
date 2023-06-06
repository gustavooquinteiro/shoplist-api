package com.economiz.shoplist;

import static io.restassured.RestAssured.enableLoggingOfRequestAndResponseIfValidationFails;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.empty;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import com.economiz.shoplist.util.ResourceUtils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CadastroProdutoIT {

	@LocalServerPort
	private int port;
	
	private static String basePath = "/produtos";
	
	private String jsonProdutoCorreto;
	
	private String jsonProdutoIncorreto;
	
	private String nomeProduto;
	
	@BeforeEach
	public void setUp() {
		enableLoggingOfRequestAndResponseIfValidationFails();
		RestAssured.basePath = basePath;
		RestAssured.port = port;
		jsonProdutoCorreto = ResourceUtils.getContentFromResource("/json/correto/produto.json");
		nomeProduto = jsonProdutoCorreto.split(":")[1].split("}")[0].split("\"")[1].trim();
		jsonProdutoIncorreto = ResourceUtils.getContentFromResource("/json/incorreto/produto.json");

	}
	
	@Test
	public void deveRetornarProduto_QuandoCadastradoCorretamente() { 
		given()
			.body(jsonProdutoCorreto)	
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
		.when()
			.post()
		.then()
			.statusCode(HttpStatus.OK.value())
			.body("nome", equalTo(nomeProduto))
			.body("precos", empty());
	}
	
	@Test
	public void deveRetornarFalha_QuandoCadastradoInorretamente() { 
		given()
			.body(jsonProdutoIncorreto)	
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
		.when()
			.post()
		.then()
			.statusCode(HttpStatus.BAD_REQUEST.value());
	}
	
	@Test
	public void deveRetornaListaProdutos() {
		given()
		.when()
			.get()
		.then()
			.statusCode(HttpStatus.OK.value());
	}
}
