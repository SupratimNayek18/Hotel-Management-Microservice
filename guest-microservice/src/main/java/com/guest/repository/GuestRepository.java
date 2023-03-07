package com.guest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guest.entities.Guest;

public interface GuestRepository extends JpaRepository<Guest, Integer> {

}
