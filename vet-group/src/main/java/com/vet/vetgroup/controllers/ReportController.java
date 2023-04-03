package com.vet.vetgroup.controllers;

import com.vet.vetgroup.dtos.requests.ReportCreationDto;
import com.vet.vetgroup.dtos.responses.ReportResponseDto;
import com.vet.vetgroup.mappers.ReportMapper;
import com.vet.vetgroup.models.Report;
import com.vet.vetgroup.services.ReportService;
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
@RequestMapping(value = "/api/reports/v2")
public class ReportController {

    @Autowired
    private ReportService service;

    @Autowired
    private ReportMapper reportMapper;

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Create a report", description = "Endpoint for create a report")
    public ResponseEntity<Long> create(
            @RequestBody @Valid ReportCreationDto dto,
            @RequestHeader(HttpHeaders.AUTHORIZATION) String token
    ) {
        return ResponseEntity.ok().body(service.insert(dto, token));
    }

    @PatchMapping(value = "/{id}", params = "approved", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Update status", description = "Endpoint for update status of report")
    public ResponseEntity<ReportResponseDto> updateApproved(
            @PathVariable Long id,
            @RequestParam(value = "approved", required = true) Boolean approved,
            @RequestHeader(HttpHeaders.AUTHORIZATION) String token
    ) {
        Report report = service.updateApproved(token, approved, id);
        return ResponseEntity.ok().body(reportMapper.convertModelToDto(report));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Find all reports", description = "Endpoint for get all reports")
    public ResponseEntity<List<ReportResponseDto>> findAll() {
        List<Report> list = service.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(reportMapper.convertModelListToDtoList(list));
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Find a report by id", description = "Endpoint for get a report by id")
    public ResponseEntity<ReportResponseDto> findById(@PathVariable Long id) {
        Report report = service.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(reportMapper.convertModelToDto(report));
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Delete by id", description = "Endpoint for delete a report by id")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
