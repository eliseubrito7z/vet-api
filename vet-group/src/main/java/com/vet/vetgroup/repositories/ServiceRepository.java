package com.vet.vetgroup.repositories;

import com.vet.vetgroup.models.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {

    @Query(value = "SELECT COUNT(*) FROM tb_services WHERE DATE(tb_services.service_date) = CURDATE()", nativeQuery = true)
    Integer findLengthOfTodayServices();

    @Query(value = "SELECT COUNT(*) FROM tb_services", nativeQuery = true)
    Integer findLengthOfAllServices();
}
