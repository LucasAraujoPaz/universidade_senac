package com.grupo11.universidade.servicos;

import java.util.List;

import com.grupo11.universidade.entidades.Aluno;
import com.grupo11.universidade.interfaces.CRUD;
import com.grupo11.universidade.repositorios.AlunoRepository;

public class AlunoService implements CRUD<Aluno> {

	@Override
	public Aluno criar(Aluno aluno) {
		return AlunoRepository.getInstance().criar(aluno);
	}

	@Override
	public Aluno obter(long id) {
		return AlunoRepository.getInstance().obter(id);
	}

	@Override
	public List<Aluno> listar() {
		return AlunoRepository.getInstance().listar();
	}

	@Override
	public Aluno atualizar(Aluno aluno) {
		return AlunoRepository.getInstance().atualizar(aluno);
	}

	@Override
	public void deletar(long id) {
		AlunoRepository.getInstance().deletar(id);
	}

}
