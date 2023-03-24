package com.vet.vetgroup.services;

import com.vet.vetgroup.dtos.requests.StaffCreationDto;
import com.vet.vetgroup.mappers.UserMapper;
import com.vet.vetgroup.models.Role;
import com.vet.vetgroup.models.RoleHistoric;
import com.vet.vetgroup.models.Staff;
import com.vet.vetgroup.models.User;
import com.vet.vetgroup.repositories.RoleRepository;
import com.vet.vetgroup.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private RoleRepository roleRepository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        Optional<User> obj =  repository.findById(id);
        return obj.get();
    }

    @Transactional
    public User insert(User user) {
        User userByUsername = repository.findByEmail(user.getEmail());

        if (userByUsername != null) {
            throw new IllegalArgumentException("Username is already registered!");
        }

        return repository.save(user);
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Transactional
    public void update(User user) {
        repository.save(user);
    }


    public ResponseEntity disableUser(String email) {
        User user = repository.findByEmail(email);

        if (!user.getAccountNonLocked()) {
            throw new IllegalArgumentException("This account is already locked!");
        }

        if (!user.getEnabled()) {
            throw new IllegalArgumentException("This account is already disabled!");
        }

        user.setAccountNonLocked(false);
        user.setEnabled(false);
        update(user);
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity enableUser(String email) {
        User user = repository.findByEmail(email);

        if (user.getAccountNonLocked()) {
            throw new IllegalArgumentException("This account is already unlocked!");
        }

        if (user.getEnabled()) {
            throw new IllegalArgumentException("This account is already enabled!");
        }

        user.setAccountNonLocked(true);
        user.setEnabled(true);
        update(user);
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity updateUserRole(RoleHistoric roleHistoric) {
        User user = repository.findByEmail(roleHistoric.getStaff().getEmail());

        if (user == null) {
            throw new IllegalArgumentException("User not found!");
        }

        Optional<Role> role = roleRepository.findById(roleHistoric.getRole().getId());
        List rolesArray = new ArrayList();
        rolesArray.add(role);
        user.setRoles(rolesArray);
        update(user);
        return ResponseEntity.noContent().build();
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        var user = repository.findByEmail(email);

        if (user != null) {
            return user;
        } else {
            throw new UsernameNotFoundException("Email " +email+ " not found!");
        }
    }
}
