package com.system.reservation.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter 
@Setter 
public class Reservation {

    @Id 
    @GeneratedValue 
    private Long id;
    @Column(nullable = false)
    private String date;
    @Column(nullable = false)
    private String time;
    @Column(nullable = false)
    private String status;

    public Reservation() {
    }

    public enum Status {
        PENDING,
        CONFIRMED,
        CANCELLED,
        COMPLETED
    }
}
