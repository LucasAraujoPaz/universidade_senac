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

import com.grupo11.universidade.entidades.Aluno;
import com.grupo11.universidade.interfaces.CRUD;
import com.grupo11.universidade.servicos.AlunoService;

@RestController
@RequestMapping("/alunos")
public class AlunoController implements CRUD<Aluno> {

	private static final AlunoService alunoService = new AlunoService(); 
	
	@Override
	@PostMapping
	public Aluno criar(@RequestBody Aluno aluno) {
		return alunoService.criar(aluno);
	}

	@Override
	@GetMapping("/{id}")
	public Aluno obter(@PathVariable long id) {
		return alunoService.obter(id);
	}

	@Override
	@GetMapping
	public List<Aluno> listar() {
		return alunoService.listar();
	}

	@Override
	@PutMapping
	public Aluno atualizar(@RequestBody Aluno aluno) {
		return alunoService.atualizar(aluno);
	}

	@Override
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable long id) {
		alunoService.deletar(id);
	}
}