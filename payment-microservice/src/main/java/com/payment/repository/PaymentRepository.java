package com.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payment.entities.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

	Payment getByReservationId(Integer reservationId);

}
