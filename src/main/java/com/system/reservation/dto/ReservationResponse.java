package com.system.reservation.dto;

public record ReservationResponse(
    Long id,
    String date,
    String time,
    String status
) {}
