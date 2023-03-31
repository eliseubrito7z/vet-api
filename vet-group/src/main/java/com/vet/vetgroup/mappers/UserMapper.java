package com.vet.vetgroup.mappers;

import com.vet.vetgroup.dtos.requests.StaffCreationDto;
import com.vet.vetgroup.models.Role;
import com.vet.vetgroup.models.User;
import com.vet.vetgroup.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserMapper {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    public User convertStaffDtoToUser(StaffCreationDto staffDto) {
        User user = new User();

        String[] nameArray = staffDto.getFullName().split(" ");
        String userName = nameArray[0] + " " + nameArray[nameArray.length - 1];

        Role role = roleRepository.findByDescription(staffDto.getRole());
        List<Role> roleList = new ArrayList<>();
        roleList.add(role);

        user.setEmail(staffDto.getEmail());
        user.setFullName(staffDto.getFullName());
        user.setPassword(passwordEncoder.encode(staffDto.getPassword().trim()).substring("{pbkdf2}".length()));
        user.setEnabled(true);
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setRoles(roleList);

        return user;
    }
}
