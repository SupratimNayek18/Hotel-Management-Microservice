package com.reservation.utils;

import java.time.LocalDate;

import com.reservation.dto.PaymentDTO;

public class CreatePaymentDTO {
	
	private CreatePaymentDTO() {}
	
	public static PaymentDTO createPaymentDTO(Integer reservationId, LocalDate date,Double amount,Integer guestId) {
		
		PaymentDTO paymentDTO = new PaymentDTO();
		
		paymentDTO.setReservationId(reservationId);
		paymentDTO.setPaymentDate(date);
		paymentDTO.setAmount(amount);
		paymentDTO.setGuestId(guestId);
		
		return paymentDTO;
		
	}

}
