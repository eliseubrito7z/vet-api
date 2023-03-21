package com.vet.vetgroup.services;

import com.vet.vetgroup.models.Role;
import com.vet.vetgroup.models.RoleHistoric;
import com.vet.vetgroup.models.User;
import com.vet.vetgroup.repositories.RoleRepository;
import com.vet.vetgroup.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
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
    public User insert(User newUser) {
        User userByUsername = repository.findByUsername(newUser.getUserName());
        if (userByUsername != null) {
            throw new IllegalArgumentException("Username is already registered!");
        }
        return repository.save(newUser);
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
        User user = repository.findByUsername(email);

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
        User user = repository.findByUsername(email);

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
        System.out.println("USER NAME " + roleHistoric.getStaff().getEmail());
        User user = repository.findByUsername(roleHistoric.getStaff().getEmail());

        System.out.println("PEGOU USER "+ user.getFullName());

        if (user == null) {
            throw new IllegalArgumentException("USER TA NULO");
        }

        Optional<Role> role = roleRepository.findById(roleHistoric.getRole().getId());
        List<Role> roleList = new ArrayList<>();
        roleList.add(role.get());

        user.setRoles(roleList);
        update(user);
        return ResponseEntity.noContent().build();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = repository.findByUsername(username);

        if (user != null) {
            return user;
        } else {
            throw new UsernameNotFoundException("Username " +username+ " not found!");
        }
    }
}
