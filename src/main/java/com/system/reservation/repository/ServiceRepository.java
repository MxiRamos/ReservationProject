package com.system.reservation.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.system.reservation.model.Services;

public interface ServiceRepository extends JpaRepository<Services, Long> {

    Optional<Services> findById(Long id);
}
