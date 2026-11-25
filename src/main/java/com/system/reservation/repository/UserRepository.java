package com.system.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.system.reservation.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
