package com.luv2code.springdemo.controller;

import org.springframework.http.HttpStatus;

public class ErrorClass {

	private HttpStatus  status;
	private String message;
	
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus notFound) {
		this.status = notFound;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
