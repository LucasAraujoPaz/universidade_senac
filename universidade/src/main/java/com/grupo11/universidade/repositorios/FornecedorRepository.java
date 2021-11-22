package com.grupo11.universidade.repositorios;

import com.grupo11.universidade.entidades.Fornecedor;
import com.grupo11.universidade.interfaces.RepositorioCRUD;
import com.grupo11.universidade.repositorios.Arquivo.Caminho;

public class FornecedorRepository implements RepositorioCRUD<Fornecedor> {
	
	@Override
	public Caminho getCaminho() {
		return Caminho.FORNECEDORES;
	}

	@Override
	public Class<Fornecedor> getClasse() {
		return Fornecedor.class;
	}
}
