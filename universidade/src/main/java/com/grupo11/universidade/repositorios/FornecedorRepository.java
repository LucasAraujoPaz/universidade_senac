package com.grupo11.universidade.repositorios;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.grupo11.universidade.entidades.Fornecedor;
import com.grupo11.universidade.interfaces.CRUD;

@RestController
public class FornecedorRepository implements CRUD<Fornecedor> {

	@Override
	public Fornecedor criar(Fornecedor entidade) {
		return null;
	}

	@Override
	public Fornecedor obter(long id) {
		return null;
	}

	@Override
	public List<Fornecedor> listar() {
		return null;
	}

	@Override
	public Fornecedor atualizar(Fornecedor a) {
		return null;
	}

	@Override
	public boolean deletar(long id) {
		return false;
	}

}
