package com.address.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.address.dto.AddressDTO;
import com.address.exceptions.AddressAdditionException;
import com.address.exceptions.AddressNotFoundException;
import com.address.service.AddressService;

@RestController
@RequestMapping("/address/api")
public class AddressController {
	
	@Autowired
	AddressService addressService;
	
	@GetMapping("/test")
	public ResponseEntity<String> hello(){
		return new ResponseEntity<>("hello",HttpStatus.OK);
	}
	
	@PostMapping("/addAdress")
	public ResponseEntity<AddressDTO> addAddress(@RequestBody AddressDTO addressDTO) throws AddressAdditionException{
		return new ResponseEntity<>(addressService.addAddress(addressDTO),HttpStatus.OK);
	}	
	
	@GetMapping("/getAddress")
	public ResponseEntity<AddressDTO> getAddress(@RequestParam Integer guestId) throws AddressNotFoundException{
		return new ResponseEntity<>(addressService.getAddress(guestId),HttpStatus.OK);
	}
	
	

}
