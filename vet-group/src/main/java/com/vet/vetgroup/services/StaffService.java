package com.vet.vetgroup.services;

import com.vet.vetgroup.dtos.requests.RoleHistoricCreationDto;
import com.vet.vetgroup.dtos.requests.StaffCreationDto;
import com.vet.vetgroup.dtos.responses.StaffLengthDto;
import com.vet.vetgroup.dtos.updates.UpdateSalary;
import com.vet.vetgroup.mappers.UserMapper;
import com.vet.vetgroup.models.Role;
import com.vet.vetgroup.models.RoleHistoric;
import com.vet.vetgroup.models.Staff;
import com.vet.vetgroup.models.User;
import com.vet.vetgroup.repositories.StaffRepository;
import com.vet.vetgroup.security.jwt.JwtTokenProvider;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class StaffService {

    @Autowired
    private StaffRepository repository;

    @Autowired
    private RoleHistoricService roleHistoricService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    public List<Staff> findAll() {
        return repository.findAll();
    }

    public Staff findById(Long id) {
        Optional<Staff> staff = repository.findById(id);

        if(staff.isEmpty()) throw new IllegalArgumentException("This Staff not exists");

        return staff.get();
    }

    public Staff findByEmail(String email) {
        Optional<Staff> staff = Optional.ofNullable(repository.findByEmail(email));

        if(staff.isEmpty()) throw new IllegalArgumentException("Staff not found!");

        return staff.get();
    }

    public Long insert(StaffCreationDto dto) {
        Staff staffModel = new Staff();
        Role role = roleService.findByDescription(dto.getRole());
        BeanUtils.copyProperties(dto, staffModel);
        staffModel.setCreatedAt(new Date());
        staffModel.setRole(role);
        staffModel.setOnDuty(false);
        staffModel.setFullName(dto.getFullName().trim());
        staffModel.setEmail(dto.getEmail().trim());

        User user = userMapper.convertStaffDtoToUser(dto);

        userService.insert(user);
        repository.save(staffModel);
        return staffModel.getId();
    }

    public Staff findByToken(String tokenUnformatted) {
        String tokenFormatted = tokenUnformatted.substring("Bearer ".length());
        String staffEmail = jwtTokenProvider.decodedToken(tokenFormatted).getSubject();
        Staff staff = findByEmail(staffEmail);

        return staff;
    }

    public Staff updateOnDuty(String tokenUnformatted, Boolean onDuty) {
        String tokenFormatted = tokenUnformatted.substring("Bearer ".length());
        String staffEmail = jwtTokenProvider.decodedToken(tokenFormatted).getSubject();
        Staff staff = findByEmail(staffEmail);

        if (staff.getOnDuty() == onDuty) {
            throw new IllegalArgumentException("The onDuty of this staff is already "+onDuty);
        }

        staff.setOnDuty(onDuty);
        update(staff);
        return staff;
    }

    public Staff updateSalary(String tokenUnformatted, UpdateSalary updateSalaryDto) {
        Staff staff = findById(updateSalaryDto.getStaff_id());
        Staff promotedBy = findByToken(tokenUnformatted);

        if (staff.getBaseSalary() == updateSalaryDto.getBaseSalary()) {
            throw new IllegalArgumentException("The salary is the same!");
        }

        RoleHistoric roleHistoric = new RoleHistoric();
        BeanUtils.copyProperties(updateSalaryDto, roleHistoric);

        roleHistoric.setRole(staff.getRole());
        roleHistoric.setStaff(staff);
        roleHistoric.setPromoter(promotedBy);
        roleHistoric.setStartedIn(new Date());

        staff.setBaseSalary(updateSalaryDto.getBaseSalary());

        roleHistoricService.insert(roleHistoric);
        update(staff);
        return staff;
    }

    public Staff updateRole(String tokenUnformatted, RoleHistoricCreationDto roleDto) {
        Staff staff = findById(roleDto.getStaff_id());
        Staff promotedBy = findByToken(tokenUnformatted);
        Role role = roleService.findByDescription(roleDto.getRoleDescription());

        if (staff.getRole() == role) {
            throw new IllegalArgumentException("This staff is already in role "+role.getDescription());
        }

        RoleHistoric roleHistoric = new RoleHistoric();
        BeanUtils.copyProperties(roleDto, roleHistoric);

        roleHistoric.setRole(role);
        roleHistoric.setStaff(staff);
        roleHistoric.setPromoter(promotedBy);
        roleHistoric.setStartedIn(new Date());

        staff.setRole(role);

        roleHistoricService.insert(roleHistoric);
        update(staff);
        return staff;
        //OBS: Returning staff to update instantly on cache of FE.
    }

    public StaffLengthDto getLengthOfStaff() {
        StaffLengthDto dto = new StaffLengthDto();

        dto.setTotal(repository.findLengthOfAllStaff());
        dto.setOnDuty(repository.findLengthOfOnDutyStaff());

        return dto;
    }



    public void deleteById(Long id) {
        repository.deleteById(id);
    }
    public void update(Staff staff) {
        repository.save(staff);
    }
}
