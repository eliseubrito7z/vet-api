package com.vet.vetgroup.repositories;

import com.vet.vetgroup.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    @Query(value = "SELECT COUNT(*) FROM tb_patients WHERE DATE(tb_patients.created_at) = CURDATE()", nativeQuery = true)
    Integer findLengthOfNewPatients();

    @Query(value = "SELECT COUNT(*) FROM tb_patients", nativeQuery = true)
    Integer findLengthOfAllPatients();

}
