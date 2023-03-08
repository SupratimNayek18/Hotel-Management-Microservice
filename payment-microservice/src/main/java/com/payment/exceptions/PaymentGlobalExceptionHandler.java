package com.payment.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PaymentGlobalExceptionHandler {

	@ExceptionHandler(PaymentNotFoundException.class)
	public ResponseEntity<String> paymentNotFoundException(PaymentNotFoundException pnfe){
		return new ResponseEntity<>(pnfe.getMessage(),HttpStatus.NOT_FOUND);
	}
	
}
