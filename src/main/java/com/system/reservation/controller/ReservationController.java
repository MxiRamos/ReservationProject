package com.system.reservation.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.system.reservation.dto.ReservationRequest;
import com.system.reservation.dto.ReservationResponse;
import com.system.reservation.service.ReservationService;

@RestController 
@RequestMapping("/api/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public List<ReservationResponse> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @GetMapping("/{id}")
    public ReservationResponse getReservationById(@PathVariable Long id) {
        return reservationService.getReservationById(id);
    }

    @GetMapping("/available")
    public List<ReservationResponse> getAvailableReservationsByDate(@PathVariable String date) {
        return reservationService.getAvailableReservationsByDate(date);
    }

    @PostMapping("/create")
    public ReservationResponse createReservation(@RequestBody ReservationRequest reservationRequest) {
        return reservationService.createReservation(reservationRequest);
    }

    @PutMapping("/update/{id}")
    public ReservationResponse updateReservation(@PathVariable Long id, @RequestBody ReservationRequest reservationRequest) {
        return reservationService.updateReservation(id, reservationRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteReservation(@PathVariable Long id) {
        reservationService.deleteReservation(id);
    }
}
