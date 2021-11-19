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

import com.grupo11.universidade.entidades.Professor;
import com.grupo11.universidade.interfaces.CRUD;
import com.grupo11.universidade.servicos.ProfessorService;

@RestController
@RequestMapping("/professores")
public class ProfessorController implements CRUD<Professor> {
	
	private static final ProfessorService professorService = new ProfessorService();
	
	@Override
	@PostMapping
	public Professor criar(@RequestBody Professor professor) {
		return professorService.criar(professor);
	}

	@Override
	@GetMapping("/{id}")
	public Professor obter(@PathVariable long id) {
		return professorService.obter(id);
	}

	@Override
	@GetMapping
	public List<Professor> listar() {
		return professorService.listar();
	}

	@Override
	@PutMapping
	public Professor atualizar(@RequestBody Professor professor) {
		return professorService.atualizar(professor);
	}

	@Override
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable long id) {
		professorService.deletar(id);
	}

}
