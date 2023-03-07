package com.guest.utils;

import com.guest.dto.GuestDTO;

public class GuestDTOCreator {
	
	public static GuestDTO createGuestDTO(String name,Integer age,Long phoneNumber) {
		GuestDTO guestDto = new GuestDTO();
		guestDto.setName(name);
		guestDto.setAge(age);
		guestDto.setPhoneNumber(phoneNumber);
		return guestDto;
	}

}
