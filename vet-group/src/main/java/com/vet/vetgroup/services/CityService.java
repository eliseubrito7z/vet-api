package com.vet.vetgroup.services;

import com.vet.vetgroup.models.City;
import com.vet.vetgroup.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {

    @Autowired
    private CityRepository repository;

    public List<City> findAll() {
        return repository.findAll();
    }

    public City findById(Long id) {
        Optional<City> role = repository.findById(id);

        if(role.isEmpty()) throw new IllegalArgumentException("This City not exists");

        return role.get();
    }

    public City findByNameAndUF(String nameAndUF) {
        return repository.findByNameAndUF(nameAndUF);
    }

    public City insert(City city) {
        return repository.save(city);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
