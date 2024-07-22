package com.emp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {

	
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<APIResponse> exceptionHandler(ResourceNotFoundException ex){
		
		APIResponse apiResponse = APIResponse.builder().message(ex.getMessage()).status("success").statusCode(HttpStatus.INTERNAL_SERVER_ERROR).build();
		return ResponseEntity.ok(apiResponse);
	}
	
}
