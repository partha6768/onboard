package com.imovies.onboard.resource.screen.repository;

import com.imovies.onboard.resource.screen.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SeatRepository extends JpaRepository<Seat, Integer>, JpaSpecificationExecutor<Seat> {

}