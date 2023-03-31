package com.vet.vetgroup.services;

import com.vet.vetgroup.dtos.requests.CityCreationDto;
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
        return repository.findByName(nameAndUF);
    }

    public City insert(CityCreationDto dto) {
        City city = new City();
        city.setName(dto.getNameAndUF().toUpperCase());
        city.setName(dto.getNameAndUF().trim());
        return repository.save(city);
    }

    public Integer getAllCitiesLength() {
        return repository.findLengthOfAllCities();
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
