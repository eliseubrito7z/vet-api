package com.vet.vetgroup.services;

import com.vet.vetgroup.dtos.requests.RoleCreationDto;
import com.vet.vetgroup.dtos.updates.NewPermissionsDto;
import com.vet.vetgroup.models.Privilege;
import com.vet.vetgroup.models.Role;
import com.vet.vetgroup.models.Staff;
import com.vet.vetgroup.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private RoleRepository repository;

    public List<Role> findAll() {
        return repository.findAll();
    }

    public Role findById(Long id) {
        Optional<Role> role = repository.findById(id);

        if(role.isEmpty()) throw new IllegalArgumentException("This Role not exists");

        return role.get();
    }

    public Role findByDescription(String description) {
        Optional<Role> role = Optional.ofNullable(repository.findByDescription(description));

        if(role.isEmpty()) throw new IllegalArgumentException("This Role not exists");

        return role.get();
    }

    public Role insert(RoleCreationDto dto) {
        Role role = new Role();
        role.setDescription(dto.getDescription());
        role.setPrivileges(dto.getPrivileges());

        return repository.save(role);
    }

    public Role addNewPermissions(NewPermissionsDto dto, Long id) {
        Role role = findById(id);
        Collection<Privilege> oldPrivileges = role.getPrivileges();
        for(Privilege newPrivilege : dto.getPrivileges()) {
            if (!oldPrivileges.contains(newPrivilege)) {
                oldPrivileges.add(newPrivilege);
            }
        }

        update(role);
        return role;
    }

    public void update(Role role) {
        repository.save(role);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
