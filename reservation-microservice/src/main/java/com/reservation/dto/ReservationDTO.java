package com.reservation.dto;

import java.time.LocalDate;

public class ReservationDTO {

	private Integer reservationId;

	private Integer roomNumber;

	private String bedType;

	private LocalDate checkIn;

	private LocalDate checkOut;

	private Integer guestId;

	public Integer getReservationId() {
		return reservationId;
	}

	public void setReservationId(Integer reservationId) {
		this.reservationId = reservationId;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getBedType() {
		return bedType;
	}

	public void setBedType(String bedType) {
		this.bedType = bedType;
	}

	public LocalDate getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(LocalDate checkIn) {
		this.checkIn = checkIn;
	}

	public LocalDate getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(LocalDate checkOut) {
		this.checkOut = checkOut;
	}

	public Integer getGuestId() {
		return guestId;
	}

	public void setGuestId(Integer guestId) {
		this.guestId = guestId;
	}

	@Override
	public String toString() {
		return "ReservationDTO [reservationId=" + reservationId + ", roomNumber=" + roomNumber + ", bedType=" + bedType
				+ ", checkIn=" + checkIn + ", checkOut=" + checkOut + ", guestId=" + guestId + "]";
	}

}
