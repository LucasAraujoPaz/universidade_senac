package com.grupo11.universidade.servicos;

import java.util.List;

import com.grupo11.universidade.entidades.Professor;
import com.grupo11.universidade.interfaces.CRUD;
import com.grupo11.universidade.repositorios.ProfessorRepository;

public class ProfessorService implements CRUD<Professor> {
	
	@Override
	public Professor criar(Professor professor) {
		return ProfessorRepository.getInstance().criar(professor);
	}

	@Override
	public Professor obter(long id) {
		return ProfessorRepository.getInstance().obter(id);
	}

	@Override
	public List<Professor> listar() {
		return ProfessorRepository.getInstance().listar();
	}

	@Override
	public Professor atualizar(Professor professor) {
		return ProfessorRepository.getInstance().atualizar(professor);
	}

	@Override
	public void deletar(long id) {
		ProfessorRepository.getInstance().deletar(id);
	}

}
