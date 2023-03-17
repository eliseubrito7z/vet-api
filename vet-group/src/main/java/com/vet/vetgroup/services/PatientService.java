package com.vet.vetgroup.services;

import com.vet.vetgroup.models.Patient;
import com.vet.vetgroup.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository repository;

    public List<Patient> findAll() {
        return repository.findAll();
    }

    public Patient findById(Long id) {
        Optional<Patient> patient = repository.findById(id);

        if(patient.isEmpty()) throw new IllegalArgumentException("This Patient not exists");

        return patient.get();
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
