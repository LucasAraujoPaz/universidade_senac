package com.grupo11.universidade.excecoes;

public class MensagemDeErro {
	
	public final String nomeDoErro;
	public final String mensagem;
	public final String origem;
	
	public MensagemDeErro(Exception e) {
		this.nomeDoErro = e.getClass().getSimpleName();
		this.mensagem = e.getMessage();
		this.origem = (e.getStackTrace().length > 0) ? e.getStackTrace()[0].toString() : "";
	}
	
	@Override
	public String toString() {
		
		return 	"Houve um erro. \n" + 
			"Nome do erro: " + nomeDoErro + "\n " +
			"Mensagem: " + mensagem +  "\n " +
			"Origem: " + origem;
	}
}
