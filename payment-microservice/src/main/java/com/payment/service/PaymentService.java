package com.payment.service;

import com.payment.dto.PaymentDTO;
import com.payment.exceptions.PaymentNotFoundException;

public interface PaymentService {
	
	public PaymentDTO addPayment(PaymentDTO paymentDTO);
	
	public PaymentDTO getPaymentDetails(Integer reservationId) throws PaymentNotFoundException;

}
