package com.system.reservation.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.system.reservation.dto.ServiceRequest;
import com.system.reservation.dto.ServiceResponse;

public interface ServiceService {

    @Transactional(readOnly = true)
    List<ServiceResponse> getAllServices();
    @Transactional(readOnly = true)
    ServiceResponse getServiceById(Long id);
    @Transactional 
    ServiceResponse createService(ServiceRequest serviceRequest);
}
