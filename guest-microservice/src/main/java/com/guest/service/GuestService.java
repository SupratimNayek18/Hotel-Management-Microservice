package com.guest.service;

import com.guest.dto.AddressDTO;
import com.guest.dto.GuestDTO;
import com.guest.dto.UserCredentialsDTO;
import com.guest.exceptions.GuestNotFoundException;
import com.guest.exceptions.GuestRegistrationException;

public interface GuestService {

	public GuestDTO registerGuest(GuestDTO guestDTO,UserCredentialsDTO userCredentialsDTO,AddressDTO addressDTO) throws GuestRegistrationException;

	public GuestDTO getGuestDetails(Integer guestId) throws GuestNotFoundException;

}
