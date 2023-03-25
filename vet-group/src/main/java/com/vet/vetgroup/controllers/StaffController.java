package com.vet.vetgroup.controllers;

import com.vet.vetgroup.dtos.requests.RoleHistoricCreationDto;
import com.vet.vetgroup.dtos.requests.StaffCreationDto;
import com.vet.vetgroup.models.Staff;
import com.vet.vetgroup.services.StaffService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/staff/v2")
public class StaffController {

    @Autowired
    private StaffService service;

    @PostMapping(value = "/create")
    public ResponseEntity create(@RequestBody @Valid StaffCreationDto dto) {
        return ResponseEntity.ok().body(service.insert(dto));
    }

    @PatchMapping(params = "on-duty")
    public ResponseEntity updateOnDuty(
            @RequestParam(name = "on-duty", required = true) Boolean onDuty,
            @RequestHeader(HttpHeaders.AUTHORIZATION) String token
    ) {
        return ResponseEntity.ok().body(service.updateOnDuty(token, onDuty));
    }

    @PutMapping(value = "/update-role")
    public ResponseEntity<Staff> updateRole(
            @RequestBody @Valid RoleHistoricCreationDto roleHistoricDto,
            @RequestHeader(HttpHeaders.AUTHORIZATION) String token
    ) {
        Staff staff = service.updateRole(token, roleHistoricDto);
        return ResponseEntity.ok().body(staff);
    }


    @GetMapping(value = "/me")
    public ResponseEntity<Staff> findByToken(@RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        Staff staff = service.findByToken(token);
        return ResponseEntity.ok().body(staff);
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
