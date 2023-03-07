package com.guest.utils;

import com.guest.dto.GuestDTO;
import com.guest.entities.Guest;

public class GuestDtoConverter {

	public static Guest GuestDtoToEntity(GuestDTO guestDto) {
		
		Guest guest = new Guest();
		guest.setName(guestDto.getName());
		guest.setPhoneNumber(guestDto.getPhoneNumber());
		guest.setAge(guestDto.getAge());
		
		return guest;

	}

	public static GuestDTO GuestEntityToDto(Guest guest) {
		
		GuestDTO guestDto = new GuestDTO();
		guestDto.setId(guest.getId());
		guestDto.setName(guest.getName());
		guestDto.setPhoneNumber(guest.getPhoneNumber());
		guestDto.setAge(guest.getAge());
		
		return guestDto;

	}

}
