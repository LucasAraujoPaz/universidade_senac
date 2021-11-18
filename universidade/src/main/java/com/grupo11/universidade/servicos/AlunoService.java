package com.grupo11.universidade.servicos;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.grupo11.universidade.entidades.Aluno;
import com.grupo11.universidade.interfaces.CRUD;
import com.grupo11.universidade.repositorios.AlunoRepository;

@RestController
public class AlunoService implements CRUD<Aluno> {

	private static final AlunoRepository alunoRepository = new AlunoRepository();
	
	@Override
	public Aluno criar(Aluno aluno) {
		return alunoRepository.criar(aluno);
	}

	@Override
	public Aluno obter(long id) {
		return alunoRepository.obter(id);
	}

	@Override
	public List<Aluno> listar() {
		return alunoRepository.listar();
	}

	@Override
	public Aluno atualizar(Aluno aluno) {
		return alunoRepository.atualizar(aluno);
	}

	@Override
	public boolean deletar(long id) {
		return alunoRepository.deletar(id);
	}

}
