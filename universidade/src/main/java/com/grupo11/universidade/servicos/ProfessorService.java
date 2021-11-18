package com.grupo11.universidade.servicos;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.grupo11.universidade.entidades.Professor;
import com.grupo11.universidade.interfaces.CRUD;
import com.grupo11.universidade.repositorios.ProfessorRepository;

@RestController
public class ProfessorService implements CRUD<Professor> {

	private static final ProfessorRepository professorRepository = new ProfessorRepository();
	
	@Override
	public Professor criar(Professor professor) {
		return professorRepository.criar(professor);
	}

	@Override
	public Professor obter(long id) {
		return professorRepository.obter(id);
	}

	@Override
	public List<Professor> listar() {
		return professorRepository.listar();
	}

	@Override
	public Professor atualizar(Professor professor) {
		return professorRepository.atualizar(professor);
	}

	@Override
	public boolean deletar(long id) {
		return professorRepository.deletar(id);
	}

}
