package com.vet.vetgroup.services;

import com.vet.vetgroup.dtos.creation.PatientCreationDto;
import com.vet.vetgroup.models.Patient;
import com.vet.vetgroup.models.Role;
import com.vet.vetgroup.repositories.RoleRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private RoleRepository repository;

    public List<Role> findAll() {
        return repository.findAll();
    }

    public Role findById(Long id) {
        Optional<Role> role = repository.findById(id);

        if(role.isEmpty()) throw new IllegalArgumentException("This Role not exists");

        return role.get();
    }

    public Role findByDescription(String description) {
        Optional<Role> role = Optional.ofNullable(repository.findByDescription(description));

        if(role.isEmpty()) throw new IllegalArgumentException("This Role not exists");

        return role.get();
    }

    public Role insert(Role role) {
        return repository.save(role);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}