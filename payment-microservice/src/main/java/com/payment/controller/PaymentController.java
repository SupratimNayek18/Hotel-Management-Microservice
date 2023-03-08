package com.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.payment.dto.PaymentDTO;
import com.payment.exceptions.PaymentNotFoundException;
import com.payment.service.PaymentService;

@RestController
@RequestMapping("/payment/api")
public class PaymentController {
	
	@Autowired
	PaymentService paymentService;
	
	@PostMapping("/addPayment")
	public ResponseEntity<PaymentDTO> addPayment(@RequestBody PaymentDTO paymentDTO){
		
		return new ResponseEntity<>(paymentService.addPayment(paymentDTO),HttpStatus.OK);
		
	}
	
	@GetMapping("/getPaymentDetails")
	public ResponseEntity<PaymentDTO> getPaymentDetails(@RequestParam Integer reservationId) throws PaymentNotFoundException{
		
		return new ResponseEntity<>(paymentService.getPaymentDetails(reservationId),HttpStatus.OK);
		
	}

}
