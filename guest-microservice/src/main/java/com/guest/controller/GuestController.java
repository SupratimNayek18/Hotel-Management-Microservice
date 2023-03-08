package com.guest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.guest.dto.AddressDTO;
import com.guest.dto.GuestDTO;
import com.guest.dto.ReservationDTO;
import com.guest.dto.UserCredentialsDTO;
import com.guest.exceptions.GuestNotFoundException;
import com.guest.exceptions.GuestRegistrationException;
import com.guest.service.GuestService;
import com.guest.service.JwtService;
import com.guest.utils.GuestDTOCreator;
import com.guest.utils.UserCredentialsDTOCreator;

@RestController
@RequestMapping("/guest/api/")
public class GuestController {

	@Autowired
	GuestService guestService;

	@Autowired
	JwtService jwtService;

	@Autowired
	AuthenticationManager authenticationManager;

	@GetMapping("test")
	public ResponseEntity<String> hello() {
		return new ResponseEntity<>("OK", HttpStatus.OK);
	}

	@PostMapping("/authenticate")
	public String authenticateAndGetToken(@RequestBody UserCredentialsDTO userCredentialsDTO) {
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userCredentialsDTO.getUserName(), userCredentialsDTO.getPassword()));
		if(authentication.isAuthenticated())
			return jwtService.generateToken(userCredentialsDTO.getUserName());
		return "Unauthorized Access";
	}

	@PostMapping("register")
	public ResponseEntity<GuestDTO> registerGuest(@RequestParam String name, @RequestParam Integer age,
			@RequestParam Long phoneNumber, @RequestParam String userName, @RequestParam String password,
			@RequestParam String role, @RequestBody AddressDTO addressDTO) throws GuestRegistrationException {

		GuestDTO guestDto = GuestDTOCreator.createGuestDTO(name, age, phoneNumber);

		UserCredentialsDTO userCredentialsDTO = UserCredentialsDTOCreator.createUserCredentialsDTO(userName, password,
				role);

		return new ResponseEntity<>(guestService.registerGuest(guestDto, userCredentialsDTO, addressDTO),
				HttpStatus.OK);

	}

	@GetMapping("getGuestDetails")
	public ResponseEntity<GuestDTO> getGuestDetails(@RequestParam Integer guestId) throws GuestNotFoundException {

		return new ResponseEntity<>(guestService.getGuestDetails(guestId), HttpStatus.OK);

	}
	
	@PostMapping("/addReservation")
	public ResponseEntity<ReservationDTO> addReservation(@RequestBody ReservationDTO reservationDTO){
		
		return new ResponseEntity<>(guestService.addReservation(reservationDTO),HttpStatus.OK);
		
	}
	
	@GetMapping("/getReservationDetails")
	public ResponseEntity<ReservationDTO> getReservationDetails(@RequestParam Integer reservationId){
		
		return new ResponseEntity<>(guestService.getReservation(reservationId),HttpStatus.OK);
		
	}

}
