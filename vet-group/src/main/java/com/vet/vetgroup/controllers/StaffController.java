package com.vet.vetgroup.controllers;

import com.vet.vetgroup.dtos.requests.RoleHistoricCreationDto;
import com.vet.vetgroup.dtos.requests.StaffCreationDto;
import com.vet.vetgroup.dtos.responses.StaffLengthDto;
import com.vet.vetgroup.dtos.responses.StaffReducedDto;
import com.vet.vetgroup.dtos.responses.StaffResponseDto;
import com.vet.vetgroup.dtos.updates.UpdateSalary;
import com.vet.vetgroup.mappers.StaffMapper;
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

    @Autowired
    private StaffMapper staffMapper;

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Create a staff", description = "Endpoint for create a staff")
    public ResponseEntity<Long> create(@RequestBody @Valid StaffCreationDto dto) {
        Long staffId = service.insert(dto);
        return ResponseEntity.ok().body(staffId);
    }

    @PatchMapping(params = "on-duty", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Update onDuty state", description = "Endpoint for update onDuty")
    public ResponseEntity<StaffReducedDto> updateOnDuty(
            @RequestParam(name = "on-duty", required = true) Boolean onDuty,
            @RequestHeader(HttpHeaders.AUTHORIZATION) String token
    ) {
        Staff staff = service.updateOnDuty(token, onDuty);
        return ResponseEntity.ok().body(staffMapper.convertModelToReducedDto(staff));
    }

    @PutMapping(value = "/update-salary", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Update salary", description = "Endpoint for update salary of staff")
    public ResponseEntity<Void> updateSalary(
            @RequestBody @Valid UpdateSalary updateSalaryDto,
            @RequestHeader(HttpHeaders.AUTHORIZATION) String token
    ) {
        Staff staff = service.updateSalary(token, updateSalaryDto);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/update-role", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Update role", description = "Endpoint for update role of staff")
    public ResponseEntity<StaffReducedDto> updateRole(
            @RequestBody @Valid RoleHistoricCreationDto roleHistoricDto,
            @RequestHeader(HttpHeaders.AUTHORIZATION) String token
    ) {
        Staff staff = service.updateRole(token, roleHistoricDto);
        return ResponseEntity.ok().body(staffMapper.convertModelToReducedDto(staff));
    }

    @GetMapping(value = "/length", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get staff length", description = "Endpoint for get staff length")
    public ResponseEntity<StaffLengthDto> findLength() {
        return ResponseEntity.ok().body(service.getLengthOfStaff());
    }

    @GetMapping(value = "/me", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get personal data", description = "Endpoint for get the personal details using token")
    public ResponseEntity<StaffReducedDto> findByToken(@RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        Staff staff = service.findByToken(token);
        return ResponseEntity.ok().body(staffMapper.convertModelToReducedDto(staff));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Find all staff", description = "Endpoint for get all staff")
    public ResponseEntity<List<StaffReducedDto>> findAll() {
        List<Staff> list = service.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(staffMapper.convertModelListToDtoList(list));
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Find a staff", description = "Endpoint for get a staff by id")
    public ResponseEntity<StaffReducedDto> findById(@PathVariable Long id) {
        Staff staff = service.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(staffMapper.convertModelToReducedDto(staff));
    }

    @GetMapping(value = "/{id}/details", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Find a staff details", description = "Endpoint for get a staff details by id")
    public ResponseEntity<StaffResponseDto> findDetailsById(@PathVariable Long id) {
        Staff staff = service.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(staffMapper.convertModelToDto(staff));
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Delete by id", description = "Endpoint for delete a staff by id")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
