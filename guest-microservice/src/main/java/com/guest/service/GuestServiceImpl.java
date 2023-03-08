package com.guest.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.guest.dto.AddressDTO;
import com.guest.dto.GuestDTO;
import com.guest.dto.ReservationDTO;
import com.guest.dto.UserCredentialsDTO;
import com.guest.entities.Guest;
import com.guest.entities.UserCredentials;
import com.guest.exceptions.GuestNotFoundException;
import com.guest.exceptions.GuestRegistrationException;
import com.guest.feignclients.FeignClientHandler;
import com.guest.repository.GuestRepository;
import com.guest.repository.UserCredentialsRepository;
import com.guest.utils.GuestDtoConverter;
import com.guest.utils.UserCredentialsDTOConverter;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class GuestServiceImpl implements GuestService {

	@Autowired
	GuestRepository guestRepository;
	
	@Autowired
	UserCredentialsRepository userCredentialsRepository;

	@Autowired
	FeignClientHandler feignClientHandler;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public GuestDTO registerGuest(GuestDTO guestDTO,UserCredentialsDTO userCredentialsDTO, AddressDTO addressDTO) throws GuestRegistrationException {
		
		Guest guest = GuestDtoConverter.GuestDtoToEntity(guestDTO);

		try {
			
			Guest savedGuest = guestRepository.save(guest);

			addressDTO.setGuestId(savedGuest.getId());
			userCredentialsDTO.setGuestId(savedGuest.getId());
			
			UserCredentials userCredentials = UserCredentialsDTOConverter.convertUserCredentialsDTOtoEntity(userCredentialsDTO);
			
			userCredentials.setPassword(passwordEncoder.encode(userCredentials.getPassword()));
			userCredentialsRepository.save(userCredentials);

			AddressDTO savedAddressDTO = feignClientHandler.addAddress(addressDTO).getBody();
			
			GuestDTO savedGuestDTO = GuestDtoConverter.GuestEntityToDto(savedGuest);
			savedGuestDTO.setAddressDTO(savedAddressDTO);
			
			return savedGuestDTO;
			
		}catch(Exception e) {
			
			throw new GuestRegistrationException("Couldn't Save Guest. Please Try Again");
		
		}
		
	}

	@Override
	public GuestDTO getGuestDetails(Integer guestId) throws GuestNotFoundException {

		Optional<Guest> guest = guestRepository.findById(guestId);

		if (guest.isPresent()) {
			
			ResponseEntity<AddressDTO> addressDTO = feignClientHandler.getAddress(guestId);
			
			GuestDTO guestDTO = GuestDtoConverter.GuestEntityToDto(guest.get());
			
			guestDTO.setAddressDTO(addressDTO.getBody());

			return guestDTO;

		}else {
			throw new GuestNotFoundException("Guest Not Found For Given Guest Id");
		}

	}

	@Override
	public ReservationDTO addReservation(ReservationDTO reservationDTO) {
		
		return feignClientHandler.addReservation(reservationDTO).getBody();
	
	}

	@Override
	public ReservationDTO getReservation(Integer reservationId) {
		
		return feignClientHandler.getReservationDetails(reservationId).getBody();
	
	}

}
