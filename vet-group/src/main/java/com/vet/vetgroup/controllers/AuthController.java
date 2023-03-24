package com.vet.vetgroup.controllers;

import com.vet.vetgroup.dtos.requests.AccountCredentialsDTO;
import com.vet.vetgroup.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {
    @Autowired
    AuthService authService;

    @SuppressWarnings("rawtypes")
    @PostMapping(value = "/signin")
    public ResponseEntity signin(@RequestBody AccountCredentialsDTO data) {
        try {
            if (checkIfParamsIsNotNull(data))
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid client request");

            var token = authService.signin(data);
            if (token == null) return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid client request");
            return token;
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e);
        }
    }

    @SuppressWarnings("rawtypes")
    @PutMapping(value = "/refresh")
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