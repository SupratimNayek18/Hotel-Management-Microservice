package com.guest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guest.entities.UserCredentials;

public interface UserCredentialsRepository extends JpaRepository<UserCredentials, Integer>{

	Optional<UserCredentials> findByUserName(String username);

}
