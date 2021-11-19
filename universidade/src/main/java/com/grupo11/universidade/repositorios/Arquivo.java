package com.grupo11.universidade.repositorios;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Arquivo {
	
	private static final String PASTA_RAIZ = "C:/universidade_teste/";
	
	public static final String CAMINHO_DE_ALUNOS = PASTA_RAIZ + "alunos.txt";
	public static final String CAMINHO_DE_FORNECEDORES = PASTA_RAIZ + "fornecedores.txt";
	public static final String CAMINHO_DE_PROFESSORES = PASTA_RAIZ + "professores.txt";
	
	static {
		criarRepositorioSeNaoExistir();
	}
	
	private static void criarRepositorioSeNaoExistir() {
		
		try {
			if ( ! Files.exists(Path.of(PASTA_RAIZ))) {
				Files.createDirectory(Path.of(PASTA_RAIZ));
				System.out.println("Pasta criada: " + PASTA_RAIZ);
			}
			
			File[] arquivos = { 
					new File(CAMINHO_DE_ALUNOS),
					new File(CAMINHO_DE_FORNECEDORES),
					new File(CAMINHO_DE_PROFESSORES) };
				
			for (File arquivo : arquivos)
				if (arquivo.createNewFile())
					System.out.println("Arquivo criado: " + arquivo.getName());
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void lerArquivo(String caminho, Consumer<String> acao) {
		
		try (Stream<String> linhas = Files.lines(Paths.get(caminho))) {

			linhas.forEachOrdered(linha -> acao.accept(linha));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String lerLinha(String caminho, long indice) {
		
		try (Stream<String> linhas = Files.lines(Paths.get(caminho))) {
			
		    return linhas.skip(indice).findFirst().orElse(null);
		    
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static void acrescentarLinha(String caminho, String linha) {
	    
	    try {
			Files.write(
					Paths.get(caminho), 
					(linha + "\n").getBytes(), 
					StandardOpenOption.APPEND);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void substituirLinha(String caminho, long indice, String linhaNova) {
		
		var linhasAtualizadas = new StringBuilder();
		int[] i = { 0 };
		
		lerArquivo(caminho, linhaAntiga -> {
			
			if (i[0] == indice)
				linhasAtualizadas.append(linhaNova).append("\n");
			else 
				linhasAtualizadas.append(linhaAntiga).append("\n");
			
			++i[0];
		});

	    try {
			Files.write(
					Paths.get(caminho), 
					linhasAtualizadas.toString().getBytes(), 
					StandardOpenOption.TRUNCATE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void zerarLinha(String caminho, long indice) {
		substituirLinha(caminho, indice, "");
	}
	
	public static Long obterNumeroDeLinhas(String caminho) {
		
		try (Stream<String> linhas = Files.lines(Paths.get(caminho))) {
		    return linhas.count();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
