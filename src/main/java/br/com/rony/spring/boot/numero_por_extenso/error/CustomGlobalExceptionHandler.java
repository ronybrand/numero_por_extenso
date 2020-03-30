package br.com.rony.spring.boot.numero_por_extenso.error;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

	private static final String MSG_ERRO = "Favor informar um número entre -99999 e 99999";
	
    @ExceptionHandler({ConstraintViolationException.class, MethodArgumentTypeMismatchException.class})
    public void badRequestHandlerExceptions(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value(), MSG_ERRO);
    }
}
