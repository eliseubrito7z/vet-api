package com.vet.vetgroup.mappers;

import com.vet.vetgroup.dtos.responses.PatientReducedDto;
import com.vet.vetgroup.models.Patient;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class PatientMapper {

    public PatientReducedDto convertModelToReducedDto(Patient model) {
        PatientReducedDto dto = new PatientReducedDto();
        BeanUtils.copyProperties(model, dto);
        return dto;
    }
}
