package com.grupo11.universidade.servicos;

import com.grupo11.universidade.entidades.Aluno;
import com.grupo11.universidade.interfaces.RepositorioCRUD;
import com.grupo11.universidade.interfaces.ServicoCRUD;
import com.grupo11.universidade.repositorios.AlunoRepository;

public class AlunoService implements ServicoCRUD<Aluno> {
	
	private static final AlunoRepository alunoRepository = new AlunoRepository();  
	
	@Override
	public RepositorioCRUD<Aluno> getRepositorio() {
		return alunoRepository;
	}
}
