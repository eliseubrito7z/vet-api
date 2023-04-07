package com.vet.vetgroup.controllers;

import com.vet.vetgroup.dtos.requests.RoleCreationDto;
import com.vet.vetgroup.dtos.updates.NewPrivilegeDto;
import com.vet.vetgroup.models.Role;
import com.vet.vetgroup.services.RoleService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/roles/v2")
public class RoleController {

    @Autowired
    private RoleService service;

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Create role", description = "Endpoint for create a new role")
    public ResponseEntity<Long> create(@RequestBody @Valid RoleCreationDto dto) {
        return ResponseEntity.ok().body(service.insert(dto));
    }

    @PutMapping(value = "/{id}/update-privileges")
    @Operation(summary = "Add new privileges", description = "Endpoint for add a new privileges")
    public ResponseEntity addNewPrivileges(
            @PathVariable Long id,
            @RequestBody @Valid NewPrivilegeDto dto
    ) {
        return ResponseEntity.ok().body(service.addNewPrivilege(dto, id));
    }

    @PutMapping(value = "/{id}/remove-privileges")
    @Operation(summary = "Remove a privileges", description = "Endpoint for remove privileges")
    public ResponseEntity removePrivileges(
            @PathVariable Long id,
            @RequestBody @Valid NewPrivilegeDto dto
    ) {
        return ResponseEntity.ok().body(service.removePrivilege(dto, id));
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Find all roles", description = "Endpoint for get all roles")
    public ResponseEntity<List<Role>> findAll() {
        List<Role> list = service.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Find a role by id", description = "Endpoint for get a role by id")
    public ResponseEntity<Role> findById(@PathVariable Long id) {
        Role role = service.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(role);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Delete by id", description = "Endpoint for delete a role by id")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
