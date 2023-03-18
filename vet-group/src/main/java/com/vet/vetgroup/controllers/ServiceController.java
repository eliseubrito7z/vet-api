package com.vet.vetgroup.controllers;

import com.vet.vetgroup.dtos.creation.ServiceCreationDto;
import com.vet.vetgroup.models.Service;
import com.vet.vetgroup.services.ServiceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/services/v2")
public class ServiceController {

    @Autowired
    private ServiceService service;

    @PostMapping(value = "/create")
    public ResponseEntity<Long> create(@RequestBody @Valid ServiceCreationDto dto) {
        return ResponseEntity.ok().body(service.insert(dto));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Service>> findAll() {
        List<Service> list = service.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Service> findById(@PathVariable Long id) {
        Service patient = service.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(patient);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
