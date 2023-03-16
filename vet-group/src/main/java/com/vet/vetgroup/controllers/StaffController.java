package com.vet.vetgroup.controllers;

import com.vet.vetgroup.models.Staff;
import com.vet.vetgroup.services.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/staff/v2")
public class StaffController {

    @Autowired
    private StaffService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Staff>> findAll() {
        List<Staff> list = service.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Staff> findById(@PathVariable Long id) {
        Staff staff = service.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(staff);
    }
}
