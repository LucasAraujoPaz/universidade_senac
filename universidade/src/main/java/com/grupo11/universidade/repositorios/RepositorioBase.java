package com.grupo11.universidade.repositorios;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RepositorioBase {
	
	public static void criar(Object entidade, String caminho) {
		
		String json = converterObjetoParaJson(entidade);
		
		Arquivo.acrescentarLinha(caminho, json);
	}

	public static <T> T obter(long id, String caminho, Class<T> classe) {
		
		String json = Arquivo.lerLinha(caminho, id);
		
		T objeto = converterJsonParaObjeto(json, classe);
		
		return objeto;
	}

	public static <T> List<T> listar(String caminho, Class<T> classe) {
		
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

	public <T> void atualizar(T entidade, String caminho, long id) {
		
		String json = converterObjetoParaJson(entidade);
		
		Arquivo.substituirLinha(caminho, id, json);
	}

	public static void deletar(String caminho, long id) {
		
		Arquivo.zerarLinha(caminho, id);
	}
	
	public static String converterObjetoParaJson(Object objeto) {

		try {
			String json = new ObjectMapper()
					.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"))
					.writeValueAsString(objeto);

			return json;

		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public static <T> T converterJsonParaObjeto(String json, Class<T> classe) {
		
		try {
			T objeto = new ObjectMapper().readValue(json, classe);
			
			return objeto;
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return null;
	}
}
