package com.vet.vetgroup.repositories;

import com.vet.vetgroup.models.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {

    Staff findByEmail(String email);
}
