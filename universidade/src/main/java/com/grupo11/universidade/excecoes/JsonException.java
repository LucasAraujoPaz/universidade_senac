package com.grupo11.universidade.excecoes;

public class JsonException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public JsonException() {
		super();
	}

	public JsonException(String mensagem) {
		super(mensagem);
	}
	
	public JsonException(Throwable causa) {
		super(causa);
	}
	
	public JsonException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
