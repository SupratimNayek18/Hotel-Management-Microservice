package com.address.service;

import com.address.dto.AddressDTO;
import com.address.exceptions.AddressAdditionException;
import com.address.exceptions.AddressNotFoundException;

public interface AddressService {
	
	public AddressDTO addAddress(AddressDTO addressDTO) throws AddressAdditionException;
	
	public AddressDTO getAddress(Integer guestId) throws AddressNotFoundException;

}
