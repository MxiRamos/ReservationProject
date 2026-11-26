package com.system.reservation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.system.reservation.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    public List<Reservation> findByDate(String date);
}
