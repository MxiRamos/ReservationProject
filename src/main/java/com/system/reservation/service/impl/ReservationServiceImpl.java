package com.system.reservation.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.system.reservation.dto.ReservationRequest;
import com.system.reservation.dto.ReservationResponse;
import com.system.reservation.model.Reservation;
import com.system.reservation.repository.ReservationRepository;
import com.system.reservation.service.ReservationService;

@Service 
public class ReservationServiceImpl implements ReservationService {
    // Implementation of the ReservationService methods

    private final ReservationRepository reservationRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public List<ReservationResponse> getAllReservations() {
        // Implementation for retrieving all reservations
        return reservationRepository.findAll().stream()
                .map(reservation -> new ReservationResponse(
                    reservation.getId(),
                    reservation.getDate(),
                    reservation.getStatus(),
                    reservation.getTime()
                ))
                .toList();
    }

    @Override 
    public ReservationResponse getReservationById(Long id) {
        // Implementation for retrieving a reservation by ID
        return reservationRepository.findById(id)
                .map(reservation -> new ReservationResponse(
                    reservation.getId(),
                    reservation.getDate(),
                    reservation.getStatus(),
                    reservation.getTime()
                ))
                .orElseThrow(() -> new RuntimeException("Reservation not found with id: " + id));
    }

    // change the date parameter to LocalDate and adjust the repository method accordingly
    @Override
    public List<ReservationResponse> getAvailableReservationsByDate(String date) {
        // Implementation for retrieving available reservations by date
        return reservationRepository.findByDate(date).stream()
                .map(reservation -> new ReservationResponse(
                    reservation.getId(),
                    reservation.getDate(),
                    reservation.getStatus(),
                    reservation.getTime()
                ))
                .toList();
    }

    @Override 
    public ReservationResponse createReservation(ReservationRequest reservationRequest) {
        // Implementation for creating a new reservation
        Reservation reservation = new Reservation(
            reservationRequest.date(),
            reservationRequest.time(),
            reservationRequest.status()
        );
        Reservation savedReservation = reservationRepository.save(reservation);
        return new ReservationResponse(
            savedReservation.getId(),
            savedReservation.getDate(),
            savedReservation.getStatus(),
            savedReservation.getTime()
        );
    }

    @Override 
    public ReservationResponse updateReservation(Long id, ReservationRequest reservationRequest) {
        // Implementation for updating an existing reservation
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation not found with id: " + id));
        reservation.setDate(reservationRequest.date());
        reservation.setTime(reservationRequest.time());
        reservation.setStatus(reservationRequest.status());
        Reservation updatedReservation = reservationRepository.save(reservation);
        return new ReservationResponse(
            updatedReservation.getId(),
            updatedReservation.getDate(),
            updatedReservation.getStatus(),
            updatedReservation.getTime()
        );
    }

    @Override 
    public void deleteReservation(Long id) {
        // Implementation for deleting a reservation
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation not found with id: " + id));
        reservationRepository.delete(reservation);
    }
}
