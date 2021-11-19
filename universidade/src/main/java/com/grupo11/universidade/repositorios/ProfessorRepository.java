package com.grupo11.universidade.repositorios;

import java.util.List;

import com.grupo11.universidade.entidades.Professor;
import com.grupo11.universidade.interfaces.CRUD;
import com.grupo11.universidade.repositorios.Arquivo.Caminho;

public class ProfessorRepository implements CRUD<Professor> {

	private static final ProfessorRepository instance = new ProfessorRepository();
	
	private ProfessorRepository() {}
	
	public synchronized static ProfessorRepository getInstance() {
		return instance;
	}
	
	@Override
	public Professor criar(Professor professor) {
		return RepositorioBase.criar(professor, Caminho.PROFESSORES);
	}

	@Override
	public Professor obter(long id) {
		return RepositorioBase.obter(id, Caminho.PROFESSORES, Professor.class);
	}

	@Override
	public List<Professor> listar() {
		return RepositorioBase.listar(Caminho.PROFESSORES, Professor.class);
	}

	@Override
	public Professor atualizar(Professor professor) {
		return RepositorioBase.atualizar(professor, Caminho.PROFESSORES);
	}

	@Override
	public void deletar(long id) {
		RepositorioBase.deletar(id, Caminho.PROFESSORES);
	}

}
