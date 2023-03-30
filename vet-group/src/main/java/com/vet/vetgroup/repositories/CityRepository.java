package com.vet.vetgroup.repositories;

import com.vet.vetgroup.models.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    City findByName(String name);

    @Query(value = "SELECT COUNT(*) FROM tb_cities", nativeQuery = true)
    Integer findLengthOfAllCities();
}
