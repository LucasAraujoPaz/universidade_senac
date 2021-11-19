package com.grupo11.universidade.repositorios;

import java.util.Calendar;
import java.util.List;

import com.grupo11.universidade.entidades.Aluno;
import com.grupo11.universidade.entidades.Aluno.Status;
import com.grupo11.universidade.interfaces.CRUD;

public class AlunoRepository implements CRUD<Aluno> {

	private static final AlunoRepository instance = new AlunoRepository();
	
	private AlunoRepository() {}
	
	public synchronized static AlunoRepository getInstance() {
		return instance;
	}
	
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
	public void deletar(long id) {
	}

}
