package com.guest.utils;

import com.guest.dto.UserCredentialsDTO;
import com.guest.entities.UserCredentials;

public class UserCredentialsDTOConverter {
	
	private UserCredentialsDTOConverter() {}

	public static UserCredentials convertUserCredentialsDTOtoEntity(UserCredentialsDTO userCredentialsDTO) {

		UserCredentials userCredentials = new UserCredentials();
		userCredentials.setUserName(userCredentialsDTO.getUserName());
		userCredentials.setPassword(userCredentialsDTO.getPassword());
		userCredentials.setGuestId(userCredentialsDTO.getGuestId());
		userCredentials.setRole(userCredentialsDTO.getRole());

		return userCredentials;

	}

	public static UserCredentialsDTO convertUserCredentialsEntitytoDTO(UserCredentials userCredentials) {

		UserCredentialsDTO userCredentialsDTO = new UserCredentialsDTO();
		
		userCredentialsDTO.setUserName(userCredentials.getUserName());
		userCredentialsDTO.setPassword(userCredentials.getPassword());
		userCredentialsDTO.setGuestId(userCredentials.getGuestId());
		userCredentialsDTO.setId(userCredentials.getId());
		userCredentialsDTO.setRole(userCredentials.getRole());
		
		return userCredentialsDTO;

	}

}
