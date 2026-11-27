package com.system.reservation.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.system.reservation.dto.ServiceRequest;
import com.system.reservation.dto.ServiceResponse;
import com.system.reservation.exception.ResourceNotFoundException;
import com.system.reservation.model.Reservation;
import com.system.reservation.model.Services;
import com.system.reservation.repository.ServiceRepository;
import com.system.reservation.service.ServiceService;

@Service 
public class ServiceServiceImpl implements ServiceService {

    private final ServiceRepository serviceRepository;

    public ServiceServiceImpl(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @Override 
    public List<ServiceResponse> getAllServices() {
        // Implementation for retrieving all services
        return serviceRepository.findAll().stream()
                .map(service -> new ServiceResponse(
                    service.getId(),
                    service.getName(),
                    service.getDescription()))
                .toList();
    }

    @Override 
    public ServiceResponse getServiceById(Long id) {
        // Implementation for retrieving a service by ID
        return serviceRepository.findById(id)
                .map(service -> new ServiceResponse(
                    service.getId(),
                    service.getName(),
                    service.getDescription()))
                .orElseThrow(() -> new ResourceNotFoundException("Service not found with id: " + id));
    }

    @Override 
    public ServiceResponse createService(ServiceRequest serviceRequest) {
        // Implementation for creating a new service
        Services service = new Services(
            serviceRequest.name(),
            serviceRequest.description()
        );
        Services savedService = serviceRepository.save(service);
        return new ServiceResponse(
            savedService.getId(),
            savedService.getName(),
            savedService.getDescription()
        );
    }
}
