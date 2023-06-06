package com.economiz.shoplist.api.exceptionhandler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex, WebRequest request) {
		String detail = "Um ou mais campos estão inválidos. Faça o preenchimento correto e tente novamente";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		ProblemType problemType = ProblemType.DADOS_INVALIDOS;
		List<Problem.Field> problemObjects = ex.getConstraintViolations().stream().map(constraintViolation -> {
			String message = constraintViolation.getMessage();
			String name = constraintViolation.getRootBean().toString();
			return Problem.Field.builder().name(name).userMessage(message).build();
		}).collect(Collectors.toList());
		
		Problem problem = createProblemBuilder(status,problemType , detail).fields(problemObjects).build();
		return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
	}

	private Problem.ProblemBuilder createProblemBuilder(HttpStatus status, ProblemType problemType, String detail) {
		return Problem.builder()
				.status(status.value())
				.title(problemType != null ? problemType.getTitle() : null)
				.type(problemType != null ? problemType.getUri() : null)
				.timestamp(LocalDateTime.now()).detail(detail);
	}

	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {

		if (body == null) {
			body = status.getReasonPhrase();
		}

		return super.handleExceptionInternal(ex, body, headers, status, request);
	}
}
