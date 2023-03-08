package com.reservation.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reservation.dto.PaymentDTO;
import com.reservation.dto.ReservationDTO;
import com.reservation.entity.Reservation;
import com.reservation.exceptions.AddReservationException;
import com.reservation.exceptions.ReservationNotFoundException;
import com.reservation.feignclients.PaymentFeignClient;
import com.reservation.repository.ReservationRepository;
import com.reservation.utils.CreatePaymentDTO;
import com.reservation.utils.ReservationDTOConverter;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	ReservationRepository reservationRepository;
	
	@Autowired
	PaymentFeignClient paymentFeignClient;

	@Override
	public ReservationDTO addReservation(ReservationDTO reservationDTO) throws AddReservationException {

		try {

			Reservation reservation = ReservationDTOConverter.convertReservationDTOtoEntity(reservationDTO);

			Reservation savedReservation = reservationRepository.save(reservation);

			PaymentDTO paymentDTO = CreatePaymentDTO.createPaymentDTO(savedReservation.getReservationId(),
					LocalDate.now(), Math.random()*1000, savedReservation.getGuestId());
			
			paymentFeignClient.addPayment(paymentDTO);

			return ReservationDTOConverter.convertReservationEntitytoDTO(savedReservation);

		} catch (Exception e) {

			throw new AddReservationException("Couldn't Add Reservation. Please Try Again");

		}

	}

	@Override
	public ReservationDTO getReserationDetails(Integer reservationId) throws ReservationNotFoundException {

		Optional<Reservation> reservation = reservationRepository.findById(reservationId);

		if (reservation.isPresent()) {

			return ReservationDTOConverter.convertReservationEntitytoDTO(reservation.get());

		}

		throw new ReservationNotFoundException("Couldn't Find Reservation For Given Id");
	}

}
