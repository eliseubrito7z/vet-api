package com.vet.vetgroup.mappers;

import com.vet.vetgroup.dtos.responses.ServiceResponseDto;
import com.vet.vetgroup.models.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
public class ServiceMapper {

    @Autowired
    private StaffMapper staffMapper;

    @Autowired
    private PatientMapper patientMapper;

    public ServiceResponseDto convertModelToDto(Service model) {
        ServiceResponseDto dto = new ServiceResponseDto();
        BeanUtils.copyProperties(model, dto);

        dto.setType(model.getType().toString());
        dto.setPaymentStatus(model.getPaymentStatus().toString());
        dto.setStatus(model.getStatus().toString());

        dto.setMedic(staffMapper.convertModelToReducedDto(model.getMedic()));
        dto.setPatient(patientMapper.convertModelToReducedDto(model.getPatient()));

        return dto;
    }

    public List<ServiceResponseDto> convertListToDto(List<Service> listModel) {
        List<ServiceResponseDto> listDto = new ArrayList<>();

        for(Service service : listModel) {
            ServiceResponseDto dto = convertModelToDto(service);
            listDto.add(dto);
        }

        return listDto;
    }
}
