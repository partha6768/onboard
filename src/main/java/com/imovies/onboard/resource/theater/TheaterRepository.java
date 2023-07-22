package com.imovies.onboard.resource.theater;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TheaterRepository extends JpaRepository<Theater, Integer>, JpaSpecificationExecutor<Theater> {

}