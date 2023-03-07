package com.address.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.address.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {
	
	@Query("select address from Address address where address.guestId=:guestId")
	public Address getByUserId(@Param("guestId") Integer guestId);

}
