package com.reservation.service;

import com.reservation.dto.ReservationDTO;
import com.reservation.exceptions.AddReservationException;
import com.reservation.exceptions.ReservationNotFoundException;

public interface ReservationService {
	
	public ReservationDTO addReservation(ReservationDTO reservationDTO) throws AddReservationException;
	
	public ReservationDTO getReserationDetails(Integer reservationId) throws ReservationNotFoundException;

}
