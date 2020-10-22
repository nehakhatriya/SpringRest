package com.luv2code.springdemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

	@ExceptionHandler
	public ResponseEntity<ErrorClass> handleException(CustomerNotFoundException exc){
		
		ErrorClass err=new ErrorClass();
		err.setStatus(HttpStatus.NOT_FOUND);
		err.setMessage(exc.getMessage());
		
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorClass> handleException(Exception exc){
		
		ErrorClass err=new ErrorClass();
		err.setStatus(HttpStatus.BAD_REQUEST);
		err.setMessage(exc.getMessage());
		
		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
	}
	
}
