package com.vet.vetgroup.controllers;

import com.vet.vetgroup.dtos.requests.RoleHistoricCreationDto;
import com.vet.vetgroup.dtos.requests.StaffCreationDto;
import com.vet.vetgroup.dtos.responses.StaffLengthDto;
import com.vet.vetgroup.dtos.updates.UpdateSalary;
import com.vet.vetgroup.models.Staff;
import com.vet.vetgroup.services.StaffService;
import io.swagger.v3.oas.annotations.Operation;
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

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Create a staff", description = "Endpoint for create a staff")
    public ResponseEntity create(@RequestBody @Valid StaffCreationDto dto) {
        return ResponseEntity.ok().body(service.insert(dto));
    }

    @PatchMapping(params = "on-duty", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Update onDuty state", description = "Endpoint for update onDuty")
    public ResponseEntity updateOnDuty(
            @RequestParam(name = "on-duty", required = true) Boolean onDuty,
            @RequestHeader(HttpHeaders.AUTHORIZATION) String token
    ) {
        return ResponseEntity.ok().body(service.updateOnDuty(token, onDuty));
    }

    @PutMapping(value = "/update-salary", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Update salary", description = "Endpoint for update salary of staff")
    public ResponseEntity<Staff> updateSalary(
            @RequestBody @Valid UpdateSalary updateSalaryDto,
            @RequestHeader(HttpHeaders.AUTHORIZATION) String token
    ) {
        Staff staff = service.updateSalary(token, updateSalaryDto);
        return ResponseEntity.ok().body(staff);
    }

    @PutMapping(value = "/update-role", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Update role", description = "Endpoint for update role of staff")
    public ResponseEntity<Staff> updateRole(
            @RequestBody @Valid RoleHistoricCreationDto roleHistoricDto,
            @RequestHeader(HttpHeaders.AUTHORIZATION) String token
    ) {
        Staff staff = service.updateRole(token, roleHistoricDto);
        return ResponseEntity.ok().body(staff);
    }

    @GetMapping(value = "/length", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get staff length", description = "Endpoint for get staff length")
    public ResponseEntity<StaffLengthDto> findLength() {
        return ResponseEntity.ok().body(service.getLengthOfStaff());
    }

    @GetMapping(value = "/me", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get personal data", description = "Endpoint for get the personal details using token")
    public ResponseEntity<Staff> findByToken(@RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        Staff staff = service.findByToken(token);
        return ResponseEntity.ok().body(staff);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Find all staff", description = "Endpoint for get all staff")
    public ResponseEntity<List<Staff>> findAll() {
        List<Staff> list = service.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Find a staff", description = "Endpoint for get a staff by id")
    public ResponseEntity<Staff> findById(@PathVariable Long id) {
        Staff staff = service.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(staff);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Delete by id", description = "Endpoint for delete a staff by id")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
