package com.system.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.system.reservation.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
