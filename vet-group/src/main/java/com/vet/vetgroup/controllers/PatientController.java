package com.vet.vetgroup.controllers;

import com.vet.vetgroup.dtos.requests.PatientCreationDto;
import com.vet.vetgroup.models.Patient;
import com.vet.vetgroup.services.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/patients/v2")
public class PatientController {

    @Autowired
    private PatientService service;

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Create patient", description = "Endpoint for create a new patient")
    public ResponseEntity<Long> create(@RequestBody @Valid PatientCreationDto dto) {
        return ResponseEntity.ok().body(service.insert(dto));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Find all patients", description = "Endpoint for get all patients")
    public ResponseEntity<List<Patient>> findAll() {
        List<Patient> list = service.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Find a patient by id", description = "Endpoint for get a patient by id")
    public ResponseEntity<Patient> findById(@PathVariable Long id) {
        Patient patient = service.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(patient);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Delete by id", description = "Endpoint for delete a patient by id")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
