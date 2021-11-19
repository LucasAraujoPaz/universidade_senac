package com.grupo11.universidade.interfaces;

import java.util.List;

public interface CRUD<T> {
	
	T criar(T entidade);
	
	T obter(long id);
	
	List<T> listar();
	
	T atualizar(T entidade);
	
	void deletar(long id);

}
