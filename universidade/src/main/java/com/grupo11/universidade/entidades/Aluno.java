package com.grupo11.universidade.entidades;

import java.util.Date;

public class Aluno extends PessoaFisica {

	private long matricula;
	
	public Aluno(
			long cpf,
			String nome,
			Date dataDeNascimento,
			String email,
			long telefone,
			long matricula) {
		
		super(cpf, nome, dataDeNascimento, email, telefone);
		
		this.matricula = matricula;
	}

	public long getMatricula() {
		return matricula;
	}

	public void setMatricula(long matricula) {
		this.matricula = matricula;
	}
	
}
