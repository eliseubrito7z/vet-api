package com.vet.vetgroup.controllers;

import com.vet.vetgroup.dtos.requests.PatientCreationDto;
import com.vet.vetgroup.dtos.responses.PatientLengthDto;
import com.vet.vetgroup.dtos.responses.PatientReducedDto;
import com.vet.vetgroup.dtos.responses.PatientResponseDto;
import com.vet.vetgroup.mappers.PatientMapper;
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

    @Autowired
    private PatientMapper patientMapper;

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Create patient", description = "Endpoint for create a new patient")
    public ResponseEntity<Long> create(@RequestBody @Valid PatientCreationDto dto) {
        return ResponseEntity.ok().body(service.insert(dto));
    }

    @GetMapping(value = "/length", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get patients length", description = "Endpoint for get patients length")
    public ResponseEntity<PatientLengthDto> getPatientsLength() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getPatientsLength());
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Find all patients", description = "Endpoint for get all patients")
    public ResponseEntity<List<PatientReducedDto>> findAll() {
        List<Patient> list = service.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(patientMapper.convertModelListToDtoList(list));
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Find a patient by id", description = "Endpoint for get a patient by id")
    public ResponseEntity<PatientResponseDto> findById(@PathVariable Long id) {
        Patient patient = service.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(patientMapper.convertModelToDto(patient));
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Delete by id", description = "Endpoint for delete a patient by id")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
