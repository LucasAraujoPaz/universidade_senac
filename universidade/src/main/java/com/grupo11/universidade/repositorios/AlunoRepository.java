package com.grupo11.universidade.repositorios;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.grupo11.universidade.entidades.Aluno;
import com.grupo11.universidade.interfaces.CRUD;

@RestController
public class AlunoRepository implements CRUD<Aluno> {

	@Override
	public Aluno criar(Aluno aluno) {
		
		aluno.setNome("criado");
		
		return aluno;
	}

	@Override
	public Aluno obter(long id) {
		return new Aluno(id, "Nome Teste", new Date(25/12/2021), "teste@teste", 7777777, 7);
	}

	@Override
	public List<Aluno> listar() {
		Aluno teste1 = new Aluno(1, "Nome Teste 1", new Date(25/12/2001), "teste1@teste", 11, 111);
		Aluno teste2 = new Aluno(2, "Nome Teste 2", new Date(25/12/2002), "teste2@teste", 22, 222);
		Aluno teste3 = new Aluno(3, "Nome Teste 3", new Date(25/12/2003), "teste3@teste", 33, 333);
		
		return List.of(teste1, teste2, teste3);
	}

	@Override
	public Aluno atualizar(Aluno aluno) {
		
		aluno.setNome("atualizado");
		
		return aluno;
	}

	@Override
	public boolean deletar(long id) {
		return true;
	}

}
