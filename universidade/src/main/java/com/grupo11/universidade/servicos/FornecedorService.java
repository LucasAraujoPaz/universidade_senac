package com.grupo11.universidade.servicos;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.grupo11.universidade.entidades.Fornecedor;
import com.grupo11.universidade.interfaces.CRUD;
import com.grupo11.universidade.repositorios.FornecedorRepository;

@RestController
public class FornecedorService implements CRUD<Fornecedor> {

	private static final FornecedorRepository fornecedorRepository = new FornecedorRepository();
	
	@Override
	public Fornecedor criar(Fornecedor fornecedor) {
		return fornecedorRepository.criar(fornecedor);
	}

	@Override
	public Fornecedor obter(long id) {
		return fornecedorRepository.obter(id);
	}

	@Override
	public List<Fornecedor> listar() {
		return fornecedorRepository.listar();
	}

	@Override
	public Fornecedor atualizar(Fornecedor fornecedor) {
		return fornecedorRepository.atualizar(fornecedor);
	}

	@Override
	public boolean deletar(long id) {
		return fornecedorRepository.deletar(id);
	}

}
