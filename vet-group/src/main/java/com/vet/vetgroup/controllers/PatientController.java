package com.vet.vetgroup.controllers;

import com.vet.vetgroup.dtos.creation.PatientCreationDto;
import com.vet.vetgroup.dtos.creation.StaffCreationDto;
import com.vet.vetgroup.models.Patient;
import com.vet.vetgroup.services.PatientService;
import com.vet.vetgroup.services.StaffService;
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

    @PostMapping(value = "/create")
    public ResponseEntity<Long> create(@RequestBody @Valid PatientCreationDto dto) {
        return ResponseEntity.ok().body(service.insert(dto));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Patient>> findAll() {
        List<Patient> list = service.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Patient> findById(@PathVariable Long id) {
        Patient patient = service.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(patient);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
