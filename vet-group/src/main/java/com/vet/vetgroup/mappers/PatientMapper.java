package com.vet.vetgroup.mappers;

import com.vet.vetgroup.dtos.responses.PatientReducedDto;
import com.vet.vetgroup.dtos.responses.PatientResponseDto;
import com.vet.vetgroup.dtos.responses.ServiceResponseDto;
import com.vet.vetgroup.models.Patient;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientMapper {

    @Autowired
    private StaffMapper staffMapper;

    public PatientReducedDto convertModelToReducedDto(Patient model) {
        PatientReducedDto dto = new PatientReducedDto();
        BeanUtils.copyProperties(model, dto);
        return dto;
    }

    public PatientResponseDto convertModelToDto(Patient model) {
        PatientResponseDto dto = new PatientResponseDto();
        BeanUtils.copyProperties(model, dto);

        List<ServiceResponseDto> services = new ArrayList<>();

        for (com.vet.vetgroup.models.Service service : model.getServices()) {
            services.add(convertModelToDtoWithoutPatient(service));
        }

        dto.setServices(services);

        return dto;
    }

    public List<PatientReducedDto> convertModelListToDtoList(List<Patient> modelList) {
        List<PatientReducedDto> dtoList = new ArrayList<>();

        for (Patient model : modelList) {
            dtoList.add(convertModelToReducedDto(model));
        }

        return dtoList;
    }

    public ServiceResponseDto convertModelToDtoWithoutPatient(com.vet.vetgroup.models.Service model) {
        ServiceResponseDto dto = new ServiceResponseDto();
        BeanUtils.copyProperties(model, dto);

        dto.setType(model.getType().toString());
        dto.setPaymentStatus(model.getPaymentStatus().toString());
        dto.setStatus(model.getStatus().toString());
        dto.setMedic(staffMapper.convertModelToReducedDto(model.getMedic()));

        return dto;
    }
}
