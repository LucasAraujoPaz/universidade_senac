package com.grupo11.universidade.entidades;

public abstract class PessoaJuridica {

	protected long cnpj;
	protected String nome;
	protected String email;
	protected long telefone;
	
	public PessoaJuridica(
			long cnpj, 
			String nome, 
			String email, 
			long telefone) {
		
		super();
		this.cnpj = cnpj;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
	}
	
	public long getCnpj() {
		return cnpj;
	}
	public void setCnpj(long cnpj) {
		this.cnpj = cnpj;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getTelefone() {
		return telefone;
	}
	public void setTelefone(long telefone) {
		this.telefone = telefone;
	}

}
