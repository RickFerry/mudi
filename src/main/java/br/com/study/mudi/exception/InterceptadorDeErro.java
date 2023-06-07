package br.com.study.mudi.exception;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.Data;

@RestControllerAdvice
public class InterceptadorDeErro {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(IllegalArgumentException.class)
	public String tratarIllegalArgumentException() {
		return "redirect:/usuario/home";
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleValidationExceptions(MethodArgumentNotValidException ex) {
		List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
		return ResponseEntity.badRequest().body(Arrays.asList(fieldErrors.stream().map(ErrorHandler::new)));
	}

	@Data
	private class ErrorHandler{
		String campo;
		String erro;
		
		public ErrorHandler(ObjectError erro) {
			this.campo = ((FieldError) erro).getField();
			this.erro = erro.getDefaultMessage();
		}
	}
}
