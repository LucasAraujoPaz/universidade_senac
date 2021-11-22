package com.grupo11.universidade.entidades;

import java.util.Date;

public class Aluno extends PessoaFisica {

	public static enum Status {
		
		INATIVO(0), ATIVO(1);

		public final int id;
		
		Status(int id) {
			this.id = id;
		}
	}
	
	private int status;

	Aluno() {}
	
	public Aluno(
			long id,
			long cpf,
			String nome,
			Date dataDeNascimento,
			String email,
			long telefone,
			Status status) {
		
		super(id, cpf, nome, dataDeNascimento, email, telefone);
		setStatus(status);
	}

	public int getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status.id;
	}
}
