package com.vet.vetgroup.services;


import com.vet.vetgroup.dtos.creation.ServiceCreationDto;
import com.vet.vetgroup.enums.ServiceStatus;
import com.vet.vetgroup.models.Service;
import com.vet.vetgroup.repositories.ServiceRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class ServiceService {

    @Autowired
    private ServiceRepository repository;

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
        BeanUtils.copyProperties(dto, serviceModel);

        if (serviceModel.getStatus() != ServiceStatus.SCHEDULED) {
            serviceModel.setServiceDate(new Date());
        }

        repository.save(serviceModel);
        return serviceModel.getId();
    }


    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
