package com.economiz.shoplist.api.exceptionhandler;

import lombok.Getter;

@Getter
public enum ProblemType {

	RECURSO_NAO_ENCONTRADO("Recurso não encontrado", "/recurso-nao-encontrado"),
	ENTIDADE_EM_USO("Entidade em uso", "/entidade-em-uso"),
	ERRO_NEGOCIO("Violação de regra de negócio", "/erro-negocio"), 
	MENSAGEM_ILEGIVEL("Mensagem ilegível", "/mensagem-ilegivel"),
	PARAMETRO_INVALIDO("Parâmetro inválido", "/parametro-invalido"),
	ERRO_DE_SISTEMA("Erro de sistema", "/erro-de-sistema"),
	DADOS_INVALIDOS("Dados inválidos", "/dados-invalidos");
	
	
	private String title;
	private String uri;
	
	private ProblemType(String title, String path) {
		this.uri = "https://shoplist.com.br" + path;
		this.title = title;
	}
}