package com.vet.vetgroup.mappers;

import com.vet.vetgroup.dtos.responses.ReportResponseDto;
import com.vet.vetgroup.dtos.responses.StaffReducedDto;
import com.vet.vetgroup.models.Report;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReportMapper {

    @Autowired
    private StaffMapper staffMapper;

    public ReportResponseDto convertModelToDto(Report model) {
        ReportResponseDto dto = new ReportResponseDto();
        BeanUtils.copyProperties(model, dto);

        StaffReducedDto createdBy = staffMapper.convertModelToReducedDto(model.getCreatedBy());

        // approved can be NULL
        if (model.getApproved() != null && model.getApproved()) {
            StaffReducedDto approver = staffMapper.convertModelToReducedDto(model.getApprover());
            dto.setApprover(approver);
        }

        dto.setType(model.getType());
        dto.setCreatedBy(createdBy);

        return dto;
    }

    public List<ReportResponseDto> convertModelListToDtoList(List<Report> modelList) {
        List<ReportResponseDto> dtoList = new ArrayList<>();

        for (Report report : modelList) {
            ReportResponseDto dto = convertModelToDto(report);
            dtoList.add(dto);
        }

        return dtoList;
    }
}
