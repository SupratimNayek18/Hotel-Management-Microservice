package com.payment.exceptions;

public class PaymentNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PaymentNotFoundException(String message) {
		super(message);
	}

}
