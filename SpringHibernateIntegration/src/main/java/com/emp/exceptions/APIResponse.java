package com.emp.exceptions;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class APIResponse {

	private String status;
	
	private HttpStatus statusCode;
	
	private String message;

	
	
	
}
