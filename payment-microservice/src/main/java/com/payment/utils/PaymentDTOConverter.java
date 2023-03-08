package com.payment.utils;

import com.payment.dto.PaymentDTO;
import com.payment.entities.Payment;

public class PaymentDTOConverter {

	private PaymentDTOConverter() {
	}

	public static Payment convertPaymentDTOtoEntity(PaymentDTO paymentDTO) {
		
		Payment payment = new Payment();
		
		payment.setReservationId(paymentDTO.getReservationId());
		payment.setPaymentDate(paymentDTO.getPaymentDate());
		payment.setGuestId(paymentDTO.getGuestId());
		payment.setAmount(paymentDTO.getAmount());
		
		return payment;
	}

	public static PaymentDTO convertPaymentEntityToDTO(Payment payment) {
		
		PaymentDTO paymentDTO = new PaymentDTO();
		
		paymentDTO.setReservationId(payment.getReservationId());
		paymentDTO.setPaymentDate(payment.getPaymentDate());
		paymentDTO.setGuestId(payment.getGuestId());
		paymentDTO.setAmount(payment.getAmount());
		paymentDTO.setPaymentId(payment.getPaymentId());
		
		return paymentDTO;

	}

}
