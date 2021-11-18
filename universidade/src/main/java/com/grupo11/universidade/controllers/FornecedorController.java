package com.grupo11.universidade.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo11.universidade.entidades.Fornecedor;
import com.grupo11.universidade.interfaces.CRUD;
import com.grupo11.universidade.servicos.FornecedorService;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController implements CRUD<Fornecedor> {

	private static final FornecedorService fornecedorService = new FornecedorService();
	
	@Override
	@PostMapping
	public Fornecedor criar(@RequestBody Fornecedor fornecedor) {
		return fornecedorService.criar(fornecedor);
	}

	@Override
	@GetMapping("/{id}")
	public Fornecedor obter(@PathVariable long id) {
		return fornecedorService.obter(id);
	}

	@Override
	@GetMapping
	public List<Fornecedor> listar() {
		return fornecedorService.listar();
	}

	@Override
	@PutMapping
	public Fornecedor atualizar(@RequestBody Fornecedor fornecedor) {
		return fornecedorService.atualizar(fornecedor);
	}

	@Override
	@DeleteMapping("/{id}")
	public boolean deletar(@PathVariable long id) {
		return fornecedorService.deletar(id);
	}

}
