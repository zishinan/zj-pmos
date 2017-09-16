package com.zj.springboot.pmos.admin.common;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.zj.springboot.pmos.admin.common.exception.LogicException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(value={LogicException.class})
	public final ResponseEntity<?> handleLogicException(LogicException ex,WebRequest request){
		HttpHeaders headers = new HttpHeaders();
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setCode(ex.getCode());
		errorResponse.setMessage(ex.getMessage());
		return handleExceptionInternal(ex, errorResponse, headers, HttpStatus.OK, request);
	}
}
