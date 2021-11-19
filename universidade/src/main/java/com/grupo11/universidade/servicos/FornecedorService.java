package com.grupo11.universidade.servicos;

import java.util.List;

import com.grupo11.universidade.entidades.Fornecedor;
import com.grupo11.universidade.interfaces.CRUD;
import com.grupo11.universidade.repositorios.FornecedorRepository;

public class FornecedorService implements CRUD<Fornecedor> {

	@Override
	public Fornecedor criar(Fornecedor fornecedor) {
		return FornecedorRepository.getInstance().criar(fornecedor);
	}

	@Override
	public Fornecedor obter(long id) {
		return FornecedorRepository.getInstance().obter(id);
	}

	@Override
	public List<Fornecedor> listar() {
		return FornecedorRepository.getInstance().listar();
	}

	@Override
	public Fornecedor atualizar(Fornecedor fornecedor) {
		return FornecedorRepository.getInstance().atualizar(fornecedor);
	}

	@Override
	public void deletar(long id) {
		FornecedorRepository.getInstance().deletar(id);
	}

}
