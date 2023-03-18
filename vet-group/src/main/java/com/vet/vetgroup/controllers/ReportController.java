package com.vet.vetgroup.controllers;

import com.vet.vetgroup.dtos.creation.ReportCreationDto;
import com.vet.vetgroup.models.Report;
import com.vet.vetgroup.services.ReportService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/reports/v2")
public class ReportController {

    @Autowired
    private ReportService service;

    @PostMapping(value = "/create")
    public ResponseEntity<Long> create(@RequestBody @Valid ReportCreationDto dto) {
        return ResponseEntity.ok().body(service.insert(dto));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Report>> findAll() {
        List<Report> list = service.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Report> findById(@PathVariable Long id) {
        Report patient = service.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(patient);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
