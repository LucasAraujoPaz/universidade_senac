package com.grupo11.universidade.entidades;

import java.util.Date;

public class Professor extends PessoaFisica {
	
	public Professor(
			long cpf,
			String nome,
			Date dataDeNascimento,
			String email,
			long telefone,
			float salario) {
		
		super(cpf, nome, dataDeNascimento, email, telefone);
		this.salario = salario;
	}
	
	private float salario;

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

}
