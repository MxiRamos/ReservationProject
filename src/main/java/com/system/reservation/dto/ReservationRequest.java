package com.system.reservation.dto;

public record ReservationRequest(
    String date,
    String time,
    String status
) {}
