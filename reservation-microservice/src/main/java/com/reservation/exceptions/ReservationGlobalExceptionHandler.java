package com.reservation.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ReservationGlobalExceptionHandler {
	
	@ExceptionHandler(AddReservationException.class)
	public ResponseEntity<String> addReservationException(AddReservationException are){
		return new ResponseEntity<>(are.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ReservationNotFoundException.class)
	public ResponseEntity<String> reservationNotFoundException(ReservationNotFoundException rnfe){
		return new ResponseEntity<>(rnfe.getMessage(),HttpStatus.NOT_FOUND);
	}
	

}
