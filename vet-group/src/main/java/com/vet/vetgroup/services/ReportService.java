package com.vet.vetgroup.services;

import com.vet.vetgroup.dtos.requests.ReportCreationDto;
import com.vet.vetgroup.models.Report;
import com.vet.vetgroup.models.Staff;
import com.vet.vetgroup.repositories.ReportRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReportService {

    @Autowired
    private ReportRepository repository;

    @Autowired
    private StaffService staffService;

    public List<Report> findAll() {
        return repository.findAll();
    }

    public Report findById(Long id) {
        Optional<Report> report = repository.findById(id);

        if(report.isEmpty()) throw new IllegalArgumentException("This Report not exists");

        return report.get();
    }

    public Long insert(ReportCreationDto dto, String token) {
        Report reportModel = new Report();
        Staff createdBy = staffService.findByToken(token);
        BeanUtils.copyProperties(dto, reportModel);

        reportModel.setCreatedBy(createdBy);
        reportModel.setCreatedAt(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")));
        reportModel.setType(dto.getType());

        repository.save(reportModel);
        return reportModel.getId();
    }

    public Report updateApproved(String token, Boolean approved, Long reportId) {
        Report report = findById(reportId);
        Staff approver = staffService.findByToken(token);

        if (approver.getRole().getId() >= 2) {
            throw new IllegalArgumentException("You dont have permission to update the report status");
        }

        report.setApproved(approved);
        report.setApprover(approver);
        update(report);
        return report;
        //OBS: returning report for set new cache instantly in FE
    }

    public void update(Report report) {
        repository.save(report);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
