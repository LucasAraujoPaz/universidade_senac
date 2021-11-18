package com.grupo11.universidade.servicos;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.grupo11.universidade.entidades.Aluno;
import com.grupo11.universidade.interfaces.CRUD;

@RestController
public class AlunoService implements CRUD<Aluno> {

	@Override
	public Aluno criar(Aluno entidade) {
		return null;
	}

	@Override
	public Aluno obter(long id) {
		return null;
	}

	@Override
	public List<Aluno> listar() {
		return null;
	}

	@Override
	public Aluno atualizar(Aluno a) {
		return null;
	}

	@Override
	public boolean deletar(long id) {
		return false;
	}

}
