package com.grupo11.universidade.repositorios;

import com.grupo11.universidade.entidades.Professor;
import com.grupo11.universidade.interfaces.RepositorioCRUD;
import com.grupo11.universidade.repositorios.Arquivo.Caminho;

public class ProfessorRepository implements RepositorioCRUD<Professor> {
	
	@Override
	public Caminho getCaminho() {
		return Caminho.PROFESSORES;
	}

	@Override
	public Class<Professor> getClasse() {
		return Professor.class;
	}
}
