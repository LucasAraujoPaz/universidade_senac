package com.grupo11.universidade.entidades;

import java.util.Date;

public abstract class PessoaFisica {

	protected long cpf;
	protected String nome;
	protected Date dataDeNascimento;
	protected String email;
	protected long telefone;
	
	public PessoaFisica(
			long cpf, 
			String nome, 
			Date dataDeNascimento, 
			String email, 
			long telefone) {
		
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.dataDeNascimento = dataDeNascimento;
		this.email = email;
		this.telefone = telefone;
	}
	
	public long getCpf() {
		return cpf;
	}
	public void setCpf(long cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}
	public void setDataDeNascimento(Date dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
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
