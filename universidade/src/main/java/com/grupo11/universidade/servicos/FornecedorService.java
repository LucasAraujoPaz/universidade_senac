package com.grupo11.universidade.servicos;

import com.grupo11.universidade.entidades.Fornecedor;
import com.grupo11.universidade.interfaces.RepositorioCRUD;
import com.grupo11.universidade.interfaces.ServicoCRUD;
import com.grupo11.universidade.repositorios.FornecedorRepository;

public class FornecedorService implements ServicoCRUD<Fornecedor> {

	private static final FornecedorRepository fornecedorRepository =
			new FornecedorRepository();  
	
	@Override
	public RepositorioCRUD<Fornecedor> getRepositorio() {
		return fornecedorRepository;
	}
}
