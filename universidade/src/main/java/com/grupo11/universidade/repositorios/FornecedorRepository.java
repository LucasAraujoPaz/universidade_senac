package com.grupo11.universidade.repositorios;

import java.util.List;

import com.grupo11.universidade.entidades.Fornecedor;
import com.grupo11.universidade.interfaces.CRUD;
import com.grupo11.universidade.repositorios.Arquivo.Caminho;

public class FornecedorRepository implements CRUD<Fornecedor> {

	private static final FornecedorRepository instance = new FornecedorRepository();
	
	private FornecedorRepository() {}
	
	public synchronized static FornecedorRepository getInstance() {
		return instance;
	}
	
	@Override
	public Fornecedor criar(Fornecedor fornecedor) {
		return RepositorioBase.criar(fornecedor, Caminho.FORNECEDORES);
	}

	@Override
	public Fornecedor obter(long id) {
		return RepositorioBase.obter(id, Caminho.FORNECEDORES, Fornecedor.class);
	}

	@Override
	public List<Fornecedor> listar() {
		return RepositorioBase.listar(Caminho.FORNECEDORES, Fornecedor.class);
	}

	@Override
	public Fornecedor atualizar(Fornecedor fornecedor) {
		return RepositorioBase.atualizar(fornecedor,  Caminho.FORNECEDORES);
	}

	@Override
	public void deletar(long id) {
		RepositorioBase.deletar(id, Caminho.FORNECEDORES);
	}

}
