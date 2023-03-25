package com.vet.vetgroup.controllers;

import com.vet.vetgroup.dtos.requests.AccountCredentialsDTO;
import com.vet.vetgroup.dtos.security.tokenDto;
import com.vet.vetgroup.services.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/auth")
@Tag(name = "Authentication", description = "Endpoints for authentication")
public class AuthController {
    @Autowired
    AuthService authService;

    @SuppressWarnings("rawtypes")
    @PostMapping(value = "/signin", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Authentication endpoint", description = "Endpoint for get the accessToken and refreshToken")
    public ResponseEntity signin(@RequestBody AccountCredentialsDTO data) {
        if (checkIfParamsIsNotNull(data))
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid client request");
        var token = authService.signin(data);
        if (token == null) return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid client request");
        return token;
    }

    @SuppressWarnings("rawtypes")
    @PutMapping(value = "/refresh", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Refresh token endpoint endpoint", description = "Endpoint for refresh the token when expired")
    public ResponseEntity refreshToken(@RequestHeader("Authorization") String refreshToken)
    {
        if (checkIfParamsIsNotNull(refreshToken))
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid client request");

        var token = authService.refreshToken(refreshToken);
        if (token == null) return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid client request");
        return token;
    }

    private static boolean checkIfParamsIsNotNull( String refreshToken) {
        return refreshToken == null || refreshToken.isBlank();
    }

    private static boolean checkIfParamsIsNotNull(AccountCredentialsDTO data) {
        return data == null || data.getEmail() == null || data.getEmail().isBlank()
                || data.getPassword() == null || data.getPassword().isBlank();
    }
}