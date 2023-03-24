package com.vet.vetgroup.services;

import com.vet.vetgroup.dtos.requests.AccountCredentialsDTO;
import com.vet.vetgroup.dtos.security.tokenDto;
import com.vet.vetgroup.repositories.UserRepository;
import com.vet.vetgroup.security.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository repository;

    @SuppressWarnings("rawtypes")
    public ResponseEntity signin(AccountCredentialsDTO data) {
        try {
            var email = data.getEmail();
            var password = data.getPassword();
            var user = repository.findByEmail(email);

            if (user == null) {
                throw new UsernameNotFoundException("Username "+email+" not found!");
            }

            if (!user.getAccountNonExpired()) {
                throw new IllegalArgumentException("This account is expired!");
            }

            if (!user.getAccountNonLocked()) {
                throw new IllegalArgumentException("This account is locked!");
            }

            if (!user.getCredentialsNonExpired()) {
                throw new IllegalArgumentException("This account's credentials have expired!");
            }

            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(email, password));

            var tokenResponse = new tokenDto();
            tokenResponse = tokenProvider.createAccessToken(email, user.getRoles());

            return ResponseEntity.ok(tokenResponse);
        } catch (Exception e) {
            throw new BadCredentialsException("Invalid username/password supplied!");
        }
    }

    @SuppressWarnings("rawtypes")
    public ResponseEntity refreshToken(String refreshToken) {
        String jwtFormatted = refreshToken.substring("Bearer ".length());

        String userEmail = tokenProvider.decodedToken(jwtFormatted).getSubject();

        var user = repository.findByEmail(userEmail);
        var tokenResponse = new tokenDto();
        if (user != null) {
            tokenResponse = tokenProvider.refreshToken(refreshToken);
        } else {
            throw new UsernameNotFoundException("User not found!");
        }
        return ResponseEntity.ok(tokenResponse);
    }
}