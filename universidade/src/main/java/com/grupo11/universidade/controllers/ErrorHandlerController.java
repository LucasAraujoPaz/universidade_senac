package com.grupo11.universidade.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.grupo11.universidade.excecoes.MensagemDeErro;
import com.grupo11.universidade.excecoes.PessoaInexistenteException;

@RestController
@ControllerAdvice
public class ErrorHandlerController implements ErrorController {

	@RequestMapping("/error")
	public String enviarMensagemDeErro() {
	    
		return "Houve um erro.\n Verifique se digitou o endereço corretamente.";
	}

	@ExceptionHandler(PessoaInexistenteException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public MensagemDeErro enviarMensagemDeErro(
			HttpServletRequest r, 
			PessoaInexistenteException e) {
	    
		e.printStackTrace();

	    return new MensagemDeErro(e);
    }
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus
	public MensagemDeErro enviarMensagemDeErro(
			HttpServletRequest r, 
			Exception e) {
	    
		e.printStackTrace();
		
	    return new MensagemDeErro(e);
    }
}
