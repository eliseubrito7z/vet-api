package com.vet.vetgroup.repositories;

import com.vet.vetgroup.models.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {

    Staff findByEmail(String email);

    @Query(value = "SELECT COUNT(*) FROM tb_staff WHERE tb_staff.on_duty = true", nativeQuery = true)
    Integer findLengthOfOnDutyStaff();

    @Query(value = "SELECT COUNT(*) FROM tb_staff", nativeQuery = true)
    Integer findLengthOfAllStaff();
}
