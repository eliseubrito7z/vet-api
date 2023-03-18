package com.vet.vetgroup.services;

import com.vet.vetgroup.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private RoleRepository repository;

    public List<com.vet.vetgroup.models.Role> findAll() {
        return repository.findAll();
    }

    public com.vet.vetgroup.models.Role findById(Long id) {
        Optional<com.vet.vetgroup.models.Role> patient = repository.findById(id);

        if(patient.isEmpty()) throw new IllegalArgumentException("This Role not exists");

        return patient.get();
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
