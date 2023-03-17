package com.vet.vetgroup.services;

import com.vet.vetgroup.models.Report;
import com.vet.vetgroup.repositories.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
