package br.com.study.mudi.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class InterceptadorDeErro {

	@ExceptionHandler(IllegalArgumentException.class)
	public String tratarIllegalArgumentException() {
		return "redirect:/usuario/home";
	}
}
