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
/**
 * Exemplo de uso:
 * 
//@ts-check

/**
* @typedef {{
* id: number,
* cpf: number,
* nome: string,
* dataDeNascimento: Date,
* email: string,
* telefone: number,
* status: number
* }} Aluno
*/

/**@type {Aluno}*/
/**
const a = {
  id: 5,
  cpf: 2,
  nome: "paz",
  dataDeNascimento: new Date(2000, 11, 25),
  email: "teste@teste.JavaScript",
  telefone: 312,
  status: 0,
}

fetch("/alunos", {
  method: "POST",
  body:  JSON.stringify(a),
  headers: {
      "Content-Type": "application/json"
  }
})
.then(response => response.json())
.then(json => console.log(json));
*/