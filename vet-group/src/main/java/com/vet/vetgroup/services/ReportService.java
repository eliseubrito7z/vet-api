package com.vet.vetgroup.services;

import com.vet.vetgroup.dtos.creation.PatientCreationDto;
import com.vet.vetgroup.dtos.creation.ReportCreationDto;
import com.vet.vetgroup.models.Patient;
import com.vet.vetgroup.models.Report;
import com.vet.vetgroup.repositories.ReportRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReportService {

    @Autowired
    private ReportRepository repository;

    public List<Report> findAll() {
        return repository.findAll();
    }

    public Report findById(Long id) {
        Optional<Report> report = repository.findById(id);

        if(report.isEmpty()) throw new IllegalArgumentException("This Report not exists");

        return report.get();
    }

    public Long insert(ReportCreationDto dto) {
        Report reportModel = new Report();
        BeanUtils.copyProperties(dto, reportModel);
        reportModel.setCreatedAt(new Date());
        repository.save(reportModel);
        return reportModel.getId();
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
