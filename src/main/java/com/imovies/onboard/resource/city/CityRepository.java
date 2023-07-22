package com.imovies.onboard.resource.city;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CityRepository extends JpaRepository<City, Integer>, JpaSpecificationExecutor<City> {

    //Page<City> findAllById(long id, Pageable pageable);
}