package com.grupo11.universidade.repositorios;

import java.util.Calendar;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.grupo11.universidade.entidades.Aluno;
import com.grupo11.universidade.entidades.Aluno.Status;
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

		Calendar c = Calendar.getInstance();
		c.set(2000, Calendar.DECEMBER, 25);

		Aluno aluno = new Aluno(id, 7L, "Nome Teste", c.getTime(),
				"teste@teste", 77L, Status.ATIVO);

		return aluno;
	}

	@Override
	public List<Aluno> listar() {

		Calendar c = Calendar.getInstance();
		c.set(2000, Calendar.DECEMBER, 25);

		Aluno teste1 = new Aluno(1L, 11L, "Nome Teste 1", c.getTime(),
				"teste1@teste", 111L, Status.ATIVO);

		Aluno teste2 = new Aluno(2L, 22L, "Nome Teste 2", c.getTime(),
				"teste2@teste", 222L, Status.ATIVO);

		Aluno teste3 = new Aluno(3L, 33L, "Nome Teste 3", c.getTime(), 
				"teste3@teste", 333L, Status.ATIVO);
		
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
