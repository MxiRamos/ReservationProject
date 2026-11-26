package com.system.reservation.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.system.reservation.dto.ReservationRequest;
import com.system.reservation.dto.ReservationResponse;

public interface ReservationService {

    @Transactional(readOnly = true)
    List<ReservationResponse> getAllReservations();
    @Transactional(readOnly = true)
    ReservationResponse getReservationById(Long id);
    @Transactional(readOnly = true)
    List<ReservationResponse> getAvailableReservationsByDate(String date);
    @Transactional
    ReservationResponse createReservation(ReservationRequest reservationRequest);
    @Transactional
    ReservationResponse updateReservation(Long id, ReservationRequest reservationRequest);
    @Transactional
    void deleteReservation(Long id);
}
