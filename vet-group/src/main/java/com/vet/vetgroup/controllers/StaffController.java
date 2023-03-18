package com.vet.vetgroup.controllers;

import com.vet.vetgroup.dtos.creation.StaffCreationDto;
import com.vet.vetgroup.models.Staff;
import com.vet.vetgroup.services.StaffService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/staff/v2")
public class StaffController {

    @Autowired
    private StaffService service;

    @PostMapping(value = "/create")
    public ResponseEntity<Long> create(@RequestBody @Valid StaffCreationDto dto) {
        return ResponseEntity.ok().body(service.insert(dto));
    }

    @PatchMapping(value = "/onDuty")
    public ResponseEntity<Void> updateOnDuty(
            @RequestParam Boolean onDuty,
            @RequestHeader(HttpHeaders.AUTHORIZATION) String token
    ) {
//        Staff staff = service.findById();
        return ResponseEntity.ok().build();
    }


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

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
