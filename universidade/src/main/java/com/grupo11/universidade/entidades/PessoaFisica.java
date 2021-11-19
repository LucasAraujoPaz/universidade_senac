package com.grupo11.universidade.entidades;

import java.util.Date;

import com.grupo11.universidade.interfaces.EntidadeComId;

public abstract class PessoaFisica implements EntidadeComId {

	protected long id;
	protected long cpf;
	protected String nome;
	protected Date dataDeNascimento;
	protected String email;
	protected long telefone;
	
	PessoaFisica() {}
	
	public PessoaFisica(
			Long id,
			Long cpf, 
			String nome, 
			Date dataDeNascimento, 
			String email, 
			Long telefone) {
		
		super();
		setId(id);
		setCpf(cpf);
		setNome(nome);
		setDataDeNascimento(dataDeNascimento);
		setEmail(email);
		setTelefone(telefone);
	}
	
	@Override
	public long getId() {
		return id;
	}
	@Override
	public void setId(long id) {
		this.id = id;
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
