package com.grupo11.universidade.repositorios;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.grupo11.universidade.excecoes.JsonException;
import com.grupo11.universidade.excecoes.PessoaInexistenteException;
import com.grupo11.universidade.interfaces.EntidadeComId;
import com.grupo11.universidade.repositorios.Arquivo.Caminho;

public class RepositorioBase {
	
	private RepositorioBase() {}
		
	public static <T extends EntidadeComId> T criar(T entidade, Caminho caminho) {
		
		long numeroDeLinhas = Arquivo.obterNumeroDeLinhas(caminho);
		
		entidade.setId(numeroDeLinhas);
		
		String json = converterObjetoParaJson(entidade);
		
		Arquivo.acrescentarLinha(json, caminho);
		
		return entidade;
	}

	public static <T> T obter(long id, Caminho caminho, Class<T> classe) {
		
		long numeroDeLinhas = Arquivo.obterNumeroDeLinhas(caminho);
		
		if (id >= numeroDeLinhas)
			throw new PessoaInexistenteException();
		
		String json = Arquivo.lerLinha(id, caminho);
		
		if (json == null || json.isBlank())
			throw new PessoaInexistenteException();
		
		T objeto = converterJsonParaObjeto(json, classe);
		
		return objeto;
	}

	public static <T> List<T> listar(Caminho caminho, Class<T> classe) {
		
		List<T> lista = new LinkedList<>(); 
		
		Arquivo.lerArquivo(caminho,
				linha -> {
					if (linha == null || linha.isBlank())
						return;
					
					T objeto = converterJsonParaObjeto(linha, classe);
					
					lista.add(objeto);
				});
		
		return lista;
	}

	public static <T extends EntidadeComId> T atualizar(T entidade, Caminho caminho) {
		
		long id = entidade.getId();
		
		long numeroDeLinhas = Arquivo.obterNumeroDeLinhas(caminho);
		
		if (id >= numeroDeLinhas)
			throw new PessoaInexistenteException();
		
		String json = converterObjetoParaJson(entidade);
		
		Arquivo.substituirLinha(id, json, caminho);
		
		return entidade;
	}

	public static void deletar(long id, Caminho caminho) {
		
		long numeroDeLinhas = Arquivo.obterNumeroDeLinhas(caminho);
		
		if (id >= numeroDeLinhas)
			throw new PessoaInexistenteException();
		
		Arquivo.zerarLinha(id, caminho);
	}
	
	public static String converterObjetoParaJson(Object objeto) {

		try {
			String json = new ObjectMapper()
					.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"))
					.writeValueAsString(objeto);

			return json;

		} catch (JsonProcessingException e) {
			throw new JsonException(e);
		}
	}
	
	public static <T> T converterJsonParaObjeto(String json, Class<T> classe) {
		
		try {
			T objeto = new ObjectMapper().readValue(json, classe);
			
			return objeto;
			
		} catch (JsonProcessingException e) {
			throw new JsonException(e);
		}
	}
}
