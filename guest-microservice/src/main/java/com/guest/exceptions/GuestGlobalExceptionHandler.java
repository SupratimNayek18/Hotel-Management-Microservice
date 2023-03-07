package com.guest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GuestGlobalExceptionHandler {
	
	@ExceptionHandler(GuestNotFoundException.class)
	public ResponseEntity<String> guestNotFoundException(GuestNotFoundException gnfe){
		return new ResponseEntity<>(gnfe.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(GuestRegistrationException.class)
	public ResponseEntity<String> guestRegistrationException(GuestRegistrationException gre){
		return new ResponseEntity<>(gre.getMessage(),HttpStatus.BAD_REQUEST);
	}

}
