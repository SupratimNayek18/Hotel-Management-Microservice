package com.guest.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.guest.dto.AddressDTO;
import com.guest.dto.ReservationDTO;

@FeignClient(value = "api-gateway")
public interface FeignClientHandler {
	
	@PostMapping("/address-microservice/address/api/addAdress")
	public ResponseEntity<AddressDTO> addAddress(@RequestBody AddressDTO addressDTO);
	
	@GetMapping("/address-microservice/address/api/getAddress")
	public ResponseEntity<AddressDTO> getAddress(@RequestParam Integer guestId);
	
	@PostMapping("/reservation-microservice/reservation/api/addReservation")
	public ResponseEntity<ReservationDTO> addReservation(@RequestBody ReservationDTO reservationDTO);
	
	@GetMapping("/reservation-microservice/reservation/api/getReservationDetails")
	public ResponseEntity<ReservationDTO> getReservationDetails(@RequestParam Integer reservationId);

}
