package com.vet.vetgroup.services;

import com.vet.vetgroup.models.RoleHistoric;
import com.vet.vetgroup.repositories.RoleHistoricRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RoleHistoricService {

    @Autowired
    private RoleHistoricRepository repository;

    public List<RoleHistoric> findAll() {
        return repository.findAll();
    }

    public RoleHistoric findById(Long id) {
        Optional<RoleHistoric> roleHistoric = repository.findById(id);

        if(roleHistoric.isEmpty()) throw new IllegalArgumentException("This RoleHistoric not exists");

        return roleHistoric.get();
    }

    public void insert(RoleHistoric roleHistoric) {
        repository.save(roleHistoric);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
