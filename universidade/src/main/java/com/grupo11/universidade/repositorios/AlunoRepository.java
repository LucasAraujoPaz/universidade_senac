package com.grupo11.universidade.repositorios;

import com.grupo11.universidade.entidades.Aluno;
import com.grupo11.universidade.interfaces.RepositorioCRUD;
import com.grupo11.universidade.repositorios.Arquivo.Caminho;

public class AlunoRepository implements RepositorioCRUD<Aluno> {
	
	@Override
	public Caminho getCaminho() {
		return Caminho.ALUNOS;
	}

	@Override
	public Class<Aluno> getClasse() {
		return Aluno.class;
	}	
}
