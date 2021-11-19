package com.grupo11.universidade.entidades;

import com.grupo11.universidade.interfaces.EntidadeComId;

public abstract class PessoaJuridica implements EntidadeComId {

	protected long id;
	protected long cnpj;
	protected String nome;
	protected String email;
	protected long telefone;
	
	PessoaJuridica() {}
	
	public PessoaJuridica(
			long id,
			long cnpj, 
			String nome, 
			String email, 
			long telefone) {
		
		super();
		setId(id);
		setCnpj(cnpj);
		setNome(nome);
		setEmail(email);
		setTelefone(telefone);
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
