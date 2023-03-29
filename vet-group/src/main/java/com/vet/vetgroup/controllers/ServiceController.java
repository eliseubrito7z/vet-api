package com.vet.vetgroup.controllers;

import com.vet.vetgroup.dtos.requests.ServiceCreationDto;
import com.vet.vetgroup.dtos.responses.ServicesLengthDto;
import com.vet.vetgroup.dtos.updates.UpdateDescription;
import com.vet.vetgroup.enums.PaymentStatus;
import com.vet.vetgroup.enums.ServiceStatus;
import com.vet.vetgroup.models.Service;
import com.vet.vetgroup.services.ServiceService;
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
@RequestMapping(value = "/api/services/v2")
public class ServiceController {

    @Autowired
    private ServiceService service;

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Create a service", description = "Endpoint for create a service")
    public ResponseEntity<Long> create(@RequestBody @Valid ServiceCreationDto dto) {
        return ResponseEntity.ok().body(service.insert(dto));
    }

    @PatchMapping(value = "/{id}/update-status", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Update status", description = "Endpoint for update status of service")
    public ResponseEntity<Service> updateStatus(
            @PathVariable Long id,
            @RequestParam(name = "status", required = true) ServiceStatus status,
            @RequestHeader(HttpHeaders.AUTHORIZATION) String token
    ) {
        Service serviceModel = service.updateStatus(token, status, id);
        return ResponseEntity.ok().body(serviceModel);
    }

    @PatchMapping(value = "/{id}/update-payment", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Update status of payment", description = "Endpoint for update status payment of report")
    public ResponseEntity<Service> updatePaymentStatus(
            @PathVariable Long id,
            @RequestParam(name = "payment-status", required = true) PaymentStatus status,
            @RequestHeader(HttpHeaders.AUTHORIZATION) String token
    ) {
        Service serviceModel = service.updatePaymentStatus(token, status, id);
        return ResponseEntity.ok().body(serviceModel);
    }

    @PutMapping(value = "/{id}/update-description", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Update description", description = "Endpoint for update description of report")
    public ResponseEntity<Service> updateDescription(
            @PathVariable Long id,
            @RequestBody @Valid UpdateDescription body,
            @RequestHeader(HttpHeaders.AUTHORIZATION) String token
    ) {
        Service serviceModel = service.updateDescription(token, body.getDescription(), id);
        return ResponseEntity.ok().body(serviceModel);
    }

    @GetMapping(value = "/length", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Find services length", description = "Endpoint for get services length")
    public ResponseEntity<ServicesLengthDto> findLength() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getLengthOfServices());
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Find all services", description = "Endpoint for get all services")
    public ResponseEntity<List<Service>> findAll() {
        List<Service> list = service.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Find a services", description = "Endpoint for get a service by id")
    public ResponseEntity<Service> findById(@PathVariable Long id) {
        Service patient = service.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(patient);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Delete by id", description = "Endpoint for delete a service by id")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
