package com.payment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.dto.PaymentDTO;
import com.payment.entities.Payment;
import com.payment.exceptions.PaymentNotFoundException;
import com.payment.repository.PaymentRepository;
import com.payment.utils.PaymentDTOConverter;

@Service
public class PaymentServiceImpl implements PaymentService {
	
	@Autowired
	PaymentRepository paymentRepository;

	@Override
	public PaymentDTO addPayment(PaymentDTO paymentDTO) {
		
		Payment payment = PaymentDTOConverter.convertPaymentDTOtoEntity(paymentDTO);
		
		Payment savedPayment = paymentRepository.save(payment);
		
		return PaymentDTOConverter.convertPaymentEntityToDTO(savedPayment);
		
	}

	@Override
	public PaymentDTO getPaymentDetails(Integer reservationId) throws PaymentNotFoundException {
		
		Payment payment = paymentRepository.getByReservationId(reservationId);
		
		if(payment!=null) return PaymentDTOConverter.convertPaymentEntityToDTO(payment);
		
		throw new PaymentNotFoundException("Payment for Given Reservation Id Not Found");
		
	}

}
