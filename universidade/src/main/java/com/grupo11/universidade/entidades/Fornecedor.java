package com.grupo11.universidade.entidades;

public class Fornecedor extends PessoaJuridica {
	
	private String descricao;
	
	public Fornecedor(
			long id,
			long cnpj, 
			String nome, 
			String email, 
			long telefone,
			String descricao) {

		super(id, cnpj, nome, email, telefone);
		setDescricao(descricao);
	}

	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
