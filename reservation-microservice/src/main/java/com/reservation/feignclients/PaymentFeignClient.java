package com.reservation.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.reservation.dto.PaymentDTO;

@FeignClient(value = "api-gateway")
public interface PaymentFeignClient {
	
	@PostMapping("/payment-microservice/payment/api/addPayment")
	public ResponseEntity<PaymentDTO> addPayment(@RequestBody PaymentDTO paymentDTO);
	
	@GetMapping("/payment-microservice/payment/api/getPaymentDetails")
	public ResponseEntity<PaymentDTO> getPaymentDetails(@RequestParam Integer reservationId);

}
