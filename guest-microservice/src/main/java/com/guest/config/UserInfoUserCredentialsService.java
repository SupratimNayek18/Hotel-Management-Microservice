package com.guest.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.guest.entities.UserCredentials;
import com.guest.repository.UserCredentialsRepository;

@Component
public class UserInfoUserCredentialsService implements UserDetailsService {
	 
	@Autowired
	private UserCredentialsRepository userCredentialsRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<UserCredentials> userCredentials = userCredentialsRepository.findByUserName(username);
		return userCredentials.map(UserInfoUserDetails::new)
						.orElseThrow(()->new UsernameNotFoundException("UserName not Found"));
		
	}

}
