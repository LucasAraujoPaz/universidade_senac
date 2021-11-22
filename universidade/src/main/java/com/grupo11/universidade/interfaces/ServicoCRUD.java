package com.grupo11.universidade.interfaces;

import java.util.List;

public interface ServicoCRUD<T extends EntidadeComId> extends CRUD<T>{
	
	public RepositorioCRUD<T> getRepositorio();
	
	@Override
	public default T criar(T entidade) {
		return getRepositorio().criar(entidade);
	}

	@Override
	public default T obter(long id) {
		return getRepositorio().obter(id);
	}

	@Override
	public default List<T> listar() {
		return getRepositorio().listar();
	}

	@Override
	public default T atualizar(T entidade) {
		return getRepositorio().atualizar(entidade);
	}

	@Override
	public default void deletar(long id) {
		getRepositorio().deletar(id);
	}
}
