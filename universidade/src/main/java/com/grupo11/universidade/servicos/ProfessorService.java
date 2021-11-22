package com.grupo11.universidade.servicos;

import com.grupo11.universidade.entidades.Professor;
import com.grupo11.universidade.interfaces.RepositorioCRUD;
import com.grupo11.universidade.interfaces.ServicoCRUD;
import com.grupo11.universidade.repositorios.ProfessorRepository;

public class ProfessorService implements ServicoCRUD<Professor> {
	
	private static final ProfessorRepository professorRepository = 
			new ProfessorRepository();
	
	@Override
	public RepositorioCRUD<Professor> getRepositorio() {
		return professorRepository;
	}
}
