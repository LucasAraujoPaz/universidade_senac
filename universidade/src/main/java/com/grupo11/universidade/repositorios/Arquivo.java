package com.grupo11.universidade.repositorios;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.function.Consumer;
import java.util.stream.Stream;

import com.grupo11.universidade.excecoes.ArquivoException;

public class Arquivo {
	
	private static final String PASTA_RAIZ = "C:/universidade_teste/";
	
	public enum Caminho {
		
		ALUNOS(PASTA_RAIZ + "alunos.txt"),
		FORNECEDORES(PASTA_RAIZ + "fornecedores.txt"),
		PROFESSORES(PASTA_RAIZ + "professores.txt");
		
		public final String nome;
		Caminho(String caminho) { this.nome = caminho; }
	}
	
	static {
		criarRepositorioSeNaoExistir();
	}
	
	private static void criarRepositorioSeNaoExistir() {

		try {
			if ( ! Files.exists(Path.of(PASTA_RAIZ))) {
				Files.createDirectory(Path.of(PASTA_RAIZ));
				System.out.println("Pasta criada: " + PASTA_RAIZ);
			}
			
			for (Caminho caminho : Caminho.values()) {
				
				File arquivo = new File(caminho.nome);
				
				if (arquivo.createNewFile())
					System.out.println("Arquivo criado: " + arquivo.getName());
			}
		
		} catch (IOException e) {
			throw new ArquivoException(e);
		}
	}
	
	public static void lerArquivo(Caminho caminho, Consumer<String> acao) {
		
		try (Stream<String> linhas = Files.lines(Paths.get(caminho.nome))) {

			linhas.forEachOrdered(linha -> acao.accept(linha));
			
		} catch (Exception e) {
			throw new ArquivoException(e);
		}
	}
	
	public static String lerLinha(long indiceDeBase0, Caminho caminho) {
		
		try (Stream<String> linhas = Files.lines(Paths.get(caminho.nome))) {
			
		    return linhas.skip(indiceDeBase0).findFirst().orElse(null);
		    
		} catch(Exception e) {
			throw new ArquivoException(e);
		}
	}
	
	public static void acrescentarLinha(String linha, Caminho caminho) {
	    
	    try {
			Files.write(
					Paths.get(caminho.nome), 
					(linha + "\n").getBytes(), 
					StandardOpenOption.APPEND);
		} catch (IOException e) {
			throw new ArquivoException(e);
		}
	}
	
	public static void substituirLinha(
			long indiceDeBase0, 
			String linhaNova, 
			Caminho caminho) {
		
		var linhasAtualizadas = new StringBuilder();
		int[] i = { 0 };
		
		lerArquivo(caminho, 
				linhaAntiga -> {
			
			if (i[0] == indiceDeBase0)
				linhasAtualizadas.append(linhaNova).append("\n");
			else 
				linhasAtualizadas.append(linhaAntiga).append("\n");
			
			++i[0]; 
			});

	    try {
			Files.write(
					Paths.get(caminho.nome), 
					linhasAtualizadas.toString().getBytes(), 
					StandardOpenOption.TRUNCATE_EXISTING);
		} catch (IOException e) {
			throw new ArquivoException(e);
		}
	}
	
	public static void zerarLinha(long indice, Caminho caminho) {
		substituirLinha(indice, "", caminho);
	}
	
	public static long obterNumeroDeLinhas(Caminho caminho) {
		
		try (Stream<String> linhas = Files.lines(Paths.get(caminho.nome))) {
		    return linhas.count();
		} catch(Exception e) {
			throw new ArquivoException(e);
		}
	}
}
