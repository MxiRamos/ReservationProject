package com.system.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.system.reservation.model.Service;

public interface ServiceRepository extends JpaRepository<Service, Long> {

}
