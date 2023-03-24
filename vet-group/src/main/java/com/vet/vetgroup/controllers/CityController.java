package com.vet.vetgroup.controllers;

import com.vet.vetgroup.dtos.requests.CityCreationDto;
import com.vet.vetgroup.models.City;
import com.vet.vetgroup.services.CityService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/cities/v2")
public class CityController {

    @Autowired
    private CityService service;

    @PostMapping(value = "/create")
    public ResponseEntity<Void> create(@RequestBody @Valid CityCreationDto cityDto) {
        service.insert(cityDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<City>> findAll() {
        List<City> list = service.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<City> findById(@PathVariable Long id) {
        City city = service.findById(id);
        return ResponseEntity.ok().body(city);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
