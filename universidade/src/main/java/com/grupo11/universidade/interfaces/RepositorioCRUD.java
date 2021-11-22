package com.grupo11.universidade.interfaces;

import java.util.List;

import com.grupo11.universidade.repositorios.Arquivo;
import com.grupo11.universidade.repositorios.Repositorio;

public interface RepositorioCRUD<T extends EntidadeComId> extends CRUD<T> {
		
	Arquivo.Caminho getCaminho();
	
	Class<T> getClasse();
	
	@Override
	public default T criar(T entidade) {
		
		return Repositorio.realizarOperacaoAtomica(repositorio ->
			repositorio.criar(entidade, getCaminho()));
	}

	@Override
	public default T obter(long id) {
		
		return Repositorio.realizarOperacaoAtomica(repositorio ->
			repositorio.obter(id, getCaminho(), getClasse()));
	}

	@Override
	public default List<T> listar() {
		
		return Repositorio.realizarOperacaoAtomica(repositorio ->
			repositorio.listar(getCaminho(), getClasse()));
	}

	@Override
	public default T atualizar(T entidade) {
		
		return Repositorio.realizarOperacaoAtomica(repositorio ->
			repositorio.atualizar(entidade, getCaminho()));
	}

	@Override
	public default void deletar(long id) {
		
		Repositorio.realizarOperacaoAtomica(repositorio ->
			{ repositorio.deletar(id, getCaminho()); return null; });
	}
}
