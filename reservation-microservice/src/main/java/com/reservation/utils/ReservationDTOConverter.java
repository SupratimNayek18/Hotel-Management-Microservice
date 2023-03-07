package com.reservation.utils;

import com.reservation.dto.ReservationDTO;
import com.reservation.entity.Reservation;

public class ReservationDTOConverter {
	
	private ReservationDTOConverter() {}
	
	public static Reservation convertReservationDTOtoEntity(ReservationDTO reservationDTO) {
		Reservation reservation = new Reservation();
		reservation.setBedType(reservationDTO.getBedType());
		reservation.setCheckIn(reservationDTO.getCheckIn());
		reservation.setCheckOut(reservationDTO.getCheckOut());
		reservation.setGuestId(reservationDTO.getGuestId());
		reservation.setRoomNumber(reservationDTO.getRoomNumber());
		
		return reservation;
	}
	
	public static ReservationDTO convertReservationEntitytoDTO(Reservation reservation) {
		ReservationDTO reservationDTO = new ReservationDTO();
		reservationDTO.setBedType(reservation.getBedType());
		reservationDTO.setCheckIn(reservation.getCheckIn());
		reservationDTO.setCheckOut(reservation.getCheckOut());
		reservationDTO.setGuestId(reservation.getGuestId());
		reservationDTO.setRoomNumber(reservation.getRoomNumber());
		reservationDTO.setReservationId(reservation.getReservationId());
		
		return reservationDTO;
	}

}
