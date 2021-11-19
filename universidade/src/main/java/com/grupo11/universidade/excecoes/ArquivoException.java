package com.grupo11.universidade.excecoes;

public class ArquivoException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ArquivoException() {
		super();
	}

	public ArquivoException(String mensagem) {
		super(mensagem);
	}
	
	public ArquivoException(Throwable causa) {
		super(causa);
	}
	
	public ArquivoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
