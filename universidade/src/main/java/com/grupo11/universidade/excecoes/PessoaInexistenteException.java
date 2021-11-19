package com.grupo11.universidade.excecoes;

public class PessoaInexistenteException extends RuntimeException {

		private static final long serialVersionUID = 1L;
		
		public PessoaInexistenteException() {
			super();
		}

		public PessoaInexistenteException(String mensagem) {
			super(mensagem);
		}
		
		public PessoaInexistenteException(Throwable causa) {
			super(causa);
		}
		
		public PessoaInexistenteException(String mensagem, Throwable causa) {
			super(mensagem, causa);
		}
}
