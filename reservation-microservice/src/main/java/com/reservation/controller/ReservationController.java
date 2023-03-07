package com.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.reservation.dto.ReservationDTO;
import com.reservation.exceptions.AddReservationException;
import com.reservation.exceptions.ReservationNotFoundException;
import com.reservation.service.ReservationService;

@RestController
@RequestMapping("/reservation/api")
public class ReservationController {
	
	@Autowired
	ReservationService reservationService;
	
	@PostMapping("/addReservation")
	public ResponseEntity<ReservationDTO> addReservation(@RequestBody ReservationDTO reservationDTO) throws AddReservationException{
		return new ResponseEntity<>(reservationService.addReservation(reservationDTO),HttpStatus.OK);
	}
	
	@GetMapping("/getReservationDetails")
	public ResponseEntity<ReservationDTO> getReservationDetails(@RequestParam Integer reservationId) throws ReservationNotFoundException{
		return new ResponseEntity<>(reservationService.getReserationDetails(reservationId),HttpStatus.OK);
	}
	

}
