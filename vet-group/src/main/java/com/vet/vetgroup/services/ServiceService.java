package com.vet.vetgroup.services;


import com.vet.vetgroup.dtos.requests.ServiceCreationDto;
import com.vet.vetgroup.dtos.responses.ServicesLengthDto;
import com.vet.vetgroup.enums.PaymentStatus;
import com.vet.vetgroup.enums.ServiceStatus;
import com.vet.vetgroup.models.City;
import com.vet.vetgroup.models.Patient;
import com.vet.vetgroup.models.Service;
import com.vet.vetgroup.models.Staff;
import com.vet.vetgroup.repositories.ServiceRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class ServiceService {

    @Autowired
    private ServiceRepository repository;

    @Autowired
    private StaffService staffService;

    @Autowired
    private PatientService patientService;

    @Autowired
    private CityService cityService;

    public List<Service> findAll() {
        return repository.findAll();
    }

    public Service findById(Long id) {
        Optional<Service> patient = repository.findById(id);

        if(patient.isEmpty()) throw new IllegalArgumentException("This Service not exists");

        return patient.get();
    }

    public Long insert(ServiceCreationDto dto) {
        Service serviceModel = new Service();
        Staff medic = staffService.findById(dto.getMedicId());
        Patient patient = patientService.findById(dto.getPatientId());
        City city = cityService.findByNameAndUF(dto.getCityNameAndUF());
        BeanUtils.copyProperties(dto, serviceModel);

        if (serviceModel.getStatus() != ServiceStatus.SCHEDULED) {
            serviceModel.setServiceDate(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")));
        }

        serviceModel.setCreatedAt(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")));
        serviceModel.setType(dto.getType());
        serviceModel.setPaymentStatus(dto.getPaymentStatus());
        serviceModel.setStatus(dto.getStatus());
        serviceModel.setMedic(medic);
        serviceModel.setPatient(patient);
        serviceModel.setCity(city);

        repository.save(serviceModel);
        return serviceModel.getId();
    }

    public Service updateStatus(String token, ServiceStatus status, Long id) {
        Service service = findById(id);
        Staff staff = staffService.findByToken(token);

        if (service.getMedic().getId() != staff.getId()) {
            throw new IllegalArgumentException("You don't have permission to alter this document");
        }

        service.setStatus(status);
        update(service);
        return service;
    }

    public Service updatePaymentStatus(String token, PaymentStatus status, Long id) {
        Service service = findById(id);

        if (service.getPaymentStatus() == PaymentStatus.CANCELED) {
            throw new IllegalArgumentException("This Service was canceled!");
        }

        if (service.getPaymentStatus() == status) {
            throw new IllegalArgumentException("This services is already with payment status "+status);
        }

        service.setPaymentStatus(status);
        update(service);
        return service;
    }

    public Service updateDescription(String token, String description, Long id) {
         Service service = findById(id);
         Staff staff = staffService.findByToken(token);

         if (service.getMedic().getId() != staff.getId()) {
             throw new IllegalArgumentException("You dont have permission to edit this document");
         }

         service.setDescription(description);
         update(service);
         return service;
    }

    public ServicesLengthDto getLengthOfServices() {
        ServicesLengthDto dto = new ServicesLengthDto();

        dto.setToday(repository.findLengthOfTodayServices());
        dto.setTotal(repository.findLengthOfAllServices());
        return dto;
    }

    public void update(Service service) {
        repository.save(service);
    }


    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
