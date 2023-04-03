package com.vet.vetgroup.mappers;

import com.vet.vetgroup.dtos.responses.*;
import com.vet.vetgroup.models.Patient;
import com.vet.vetgroup.models.Role;
import com.vet.vetgroup.models.RoleHistoric;
import com.vet.vetgroup.models.Staff;
import com.vet.vetgroup.services.RoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StaffMapper {

    public StaffReducedDto convertModelToReducedDto(Staff model) {
        StaffReducedDto dto = new StaffReducedDto();
        BeanUtils.copyProperties(model, dto);

        return dto;
    }

    public StaffResponseDto convertModelToDto(Staff model) {
        StaffResponseDto dto = new StaffResponseDto();
        BeanUtils.copyProperties(model, dto);

        List<RoleHistoricResponseDto> roleHistoricDto = new ArrayList<>();
        List<ServiceResponseDto> serviceDtoList = new ArrayList<>();

        for (com.vet.vetgroup.models.Service service : model.getService()) {
            ServiceResponseDto serviceDto = convertModelToDtoWithoutStaff(service);
            serviceDtoList.add(serviceDto);
        }

        for (RoleHistoric historic : model.getRoleHistoric()) {
            RoleHistoricResponseDto roleDto = new RoleHistoricResponseDto();
            BeanUtils.copyProperties(historic, roleDto);

            StaffReducedDto promoterReduced = convertModelToReducedDto(historic.getPromoter());
            roleDto.setPromoter(promoterReduced);
            roleHistoricDto.add(roleDto);
        }

        dto.setRoleHistoric(roleHistoricDto);
        dto.setServicesList(serviceDtoList);

        return dto;
    }

    public List<StaffReducedDto> convertModelListToDtoList(List<Staff> modelList) {
        List<StaffReducedDto> dtoList = new ArrayList<>();

        for (Staff staff : modelList) {
            dtoList.add(convertModelToReducedDto(staff));
        }

        return dtoList;
    }

    public ServiceResponseDto convertModelToDtoWithoutStaff(com.vet.vetgroup.models.Service model) {
        ServiceResponseDto dto = new ServiceResponseDto();
        BeanUtils.copyProperties(model, dto);

        dto.setType(model.getType().toString());
        dto.setPaymentStatus(model.getPaymentStatus().toString());
        dto.setStatus(model.getStatus().toString());
        dto.setPatient(convertModelToReducedDto(model.getPatient()));

        return dto;
    }

    public PatientReducedDto convertModelToReducedDto(Patient model) {
        PatientReducedDto dto = new PatientReducedDto();
        BeanUtils.copyProperties(model, dto);
        return dto;
    }
}
