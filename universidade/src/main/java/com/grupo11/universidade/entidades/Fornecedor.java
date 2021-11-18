package com.grupo11.universidade.entidades;

public class Fornecedor extends PessoaJuridica {
	
	private String descricao;
	
	public Fornecedor(
			long cnpj, 
			String nome, 
			String email, 
			long telefone) {

		super(cnpj, nome, email, telefone);
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
