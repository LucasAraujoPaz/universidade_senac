package com.grupo11.universidade.repositorios;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.grupo11.universidade.entidades.Professor;
import com.grupo11.universidade.interfaces.CRUD;

@RestController
public class ProfessorRepository implements CRUD<Professor> {

	@Override
	public Professor criar(Professor professor) {
		return null;
	}

	@Override
	public Professor obter(long id) {
		return null;
	}

	@Override
	public List<Professor> listar() {
		return null;
	}

	@Override
	public Professor atualizar(Professor professor) {
		return null;
	}

	@Override
	public boolean deletar(long id) {
		return false;
	}

}
