package com.guest.utils;

import com.guest.dto.UserCredentialsDTO;

public class UserCredentialsDTOCreator {
	
	private UserCredentialsDTOCreator() {}
	
	public static UserCredentialsDTO createUserCredentialsDTO(String userName,String password,String role) {
		
		UserCredentialsDTO userCredentialsDTO = new UserCredentialsDTO();
		
		userCredentialsDTO.setUserName(userName);
		userCredentialsDTO.setPassword(password);
		userCredentialsDTO.setRole(role);
		
		return userCredentialsDTO;
	}

}
