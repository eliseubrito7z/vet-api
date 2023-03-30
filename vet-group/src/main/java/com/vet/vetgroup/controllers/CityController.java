package com.vet.vetgroup.controllers;

import com.vet.vetgroup.dtos.requests.CityCreationDto;
import com.vet.vetgroup.models.City;
import com.vet.vetgroup.services.CityService;
import io.swagger.v3.oas.annotations.Operation;
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

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Create city", description = "Endpoint for create a new city")
    public ResponseEntity<Void> create(@RequestBody @Valid CityCreationDto cityDto) {
        service.insert(cityDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/length", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get cities length", description = "Endpoint for get cities length")
    public ResponseEntity<Integer> getCitiesLength() {
        return ResponseEntity.ok().body(service.getAllCitiesLength());
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Find all cities", description = "Endpoint for find all cities created")
    public ResponseEntity<List<City>> findAll() {
        List<City> list = service.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Find a city by id", description = "Endpoint for get a city by id")
    public ResponseEntity<City> findById(@PathVariable Long id) {
        City city = service.findById(id);
        return ResponseEntity.ok().body(city);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Delete by id", description = "Endpoint for delete a city by id")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
