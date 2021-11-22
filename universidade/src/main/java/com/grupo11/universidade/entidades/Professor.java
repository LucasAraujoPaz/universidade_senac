package com.grupo11.universidade.entidades;

import java.util.Date;

public class Professor extends PessoaFisica {

	Professor() {};
	
	public Professor(
			long id,
			long cpf,
			String nome,
			Date dataDeNascimento,
			String email,
			long telefone,
			float salario) {
		
		super(id, cpf, nome, dataDeNascimento, email, telefone);
		setSalario(salario);
	}
	
	private float salario;

	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		this.salario = salario;
	}
}
