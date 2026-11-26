package com.system.reservation.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.system.reservation.dto.ReservationResponse;

public interface ReservationService {

    @Transactional(readOnly = true)
    List<ReservationResponse> getAllReservations();
    @Transactional(readOnly = true)
    ReservationResponse getReservationById(Long id);
    @Transactional(readOnly = true)
    List<ReservationResponse> getAvailableReservationsByDate(String date);
    @Transactional
    ReservationResponse createReservation(ReservationResponse reservationResponse);
    @Transactional
    ReservationResponse updateReservation(Long id, ReservationResponse reservationResponse);
    @Transactional
    void deleteReservation(Long id);
}
