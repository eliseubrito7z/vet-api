package com.vet.vetgroup.services;

import com.vet.vetgroup.models.Staff;
import com.vet.vetgroup.repositories.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StaffService {

    @Autowired
    private StaffRepository repository;

    public List<Staff> findAll() {
        return repository.findAll();
    }

    public Staff findById(Long id) {
        Optional<Staff> staff = repository.findById(id);

        if(staff.isEmpty()) throw new IllegalArgumentException("This Staff not exists");

        return staff.get();
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
