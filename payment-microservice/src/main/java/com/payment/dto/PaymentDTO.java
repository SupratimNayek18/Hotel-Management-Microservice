package com.payment.dto;

import java.time.LocalDate;

public class PaymentDTO {

	private Integer paymentId;

	private Integer reservationId;

	private Integer guestId;

	private LocalDate paymentDate;

	private Double amount;

	public Integer getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}

	public Integer getReservationId() {
		return reservationId;
	}

	public void setReservationId(Integer reservationId) {
		this.reservationId = reservationId;
	}

	public Integer getGuestId() {
		return guestId;
	}

	public void setGuestId(Integer guestId) {
		this.guestId = guestId;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "PaymentDTO [paymentId=" + paymentId + ", reservationId=" + reservationId + ", guestId=" + guestId
				+ ", paymentDate=" + paymentDate + ", amount=" + amount + "]";
	}

}
