package com.address.utils;

import com.address.dto.AddressDTO;
import com.address.entity.Address;

public class AddressDtoConverter {
	
	private AddressDtoConverter() {}
	
	public static Address addressDtoToEntity(AddressDTO addressDTO) {
		Address address = new Address();
		address.setStreet(addressDTO.getStreet());
		address.setCity(addressDTO.getCity());
		address.setLandmark(addressDTO.getLandmark());
		address.setPincode(addressDTO.getPincode());
		address.setGuestId(addressDTO.getGuestId());
		
		return address;
	}
	
	public static AddressDTO addressEntitytoDto(Address address) {
		AddressDTO addressDTO = new AddressDTO();
		addressDTO.setStreet(address.getStreet());
		addressDTO.setCity(address.getCity());
		addressDTO.setLandmark(address.getLandmark());
		addressDTO.setPincode(address.getPincode());
		addressDTO.setGuestId(address.getGuestId());
		
		return addressDTO;
	}

}
