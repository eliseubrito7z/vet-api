package com.vet.vetgroup.mappers;

import com.vet.vetgroup.dtos.responses.RoleHistoricResponseDto;
import com.vet.vetgroup.dtos.responses.StaffReducedDto;
import com.vet.vetgroup.dtos.responses.StaffResponseDto;
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

        for (RoleHistoric historic : model.getRoleHistoric()) {
            RoleHistoricResponseDto roleDto = new RoleHistoricResponseDto();
            BeanUtils.copyProperties(historic, roleDto);

            StaffReducedDto promoterReduced = convertModelToReducedDto(historic.getPromoter());
            roleDto.setPromoter(promoterReduced);
            roleHistoricDto.add(roleDto);
        }

        dto.setRoleHistoric(roleHistoricDto);
        return dto;
    }

    public List<StaffReducedDto> convertModelListToDtoList(List<Staff> modelList) {
        List<StaffReducedDto> dtoList = new ArrayList<>();

        for (Staff staff : modelList) {
            dtoList.add(convertModelToReducedDto(staff));
        }

        return dtoList;
    }
}
