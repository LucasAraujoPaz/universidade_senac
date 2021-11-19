package com.grupo11.universidade.repositorios;

import java.util.List;

import com.grupo11.universidade.entidades.Aluno;
import com.grupo11.universidade.interfaces.CRUD;
import com.grupo11.universidade.repositorios.Arquivo.Caminho;

public class AlunoRepository implements CRUD<Aluno> {

	private static final AlunoRepository instance = new AlunoRepository();
	
	private AlunoRepository() {}
	
	public synchronized static AlunoRepository getInstance() {
		return instance;
	}
	
	@Override
	public Aluno criar(Aluno aluno) {

		return RepositorioBase.criar(aluno, Caminho.ALUNOS);
	}

	@Override
	public Aluno obter(long id) {

		return RepositorioBase.obter(id, Caminho.ALUNOS, Aluno.class);
	}

	@Override
	public List<Aluno> listar() {

		return RepositorioBase.listar(Caminho.ALUNOS, Aluno.class);
	}

	@Override
	public Aluno atualizar(Aluno aluno) {

		return RepositorioBase.atualizar(aluno, Caminho.ALUNOS);
	}

	@Override
	public void deletar(long id) {
		RepositorioBase.deletar(id, Caminho.ALUNOS);
	}

}
