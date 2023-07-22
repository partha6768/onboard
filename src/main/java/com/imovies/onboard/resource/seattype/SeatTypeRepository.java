package com.imovies.onboard.resource.seattype;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SeatTypeRepository extends JpaRepository<SeatType, String>, JpaSpecificationExecutor<SeatType> {

}