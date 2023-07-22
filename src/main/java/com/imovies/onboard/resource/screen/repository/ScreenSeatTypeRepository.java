package com.imovies.onboard.resource.screen.repository;

import com.imovies.onboard.resource.screen.entity.ScreenSeatType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ScreenSeatTypeRepository extends JpaRepository<ScreenSeatType, Integer>, JpaSpecificationExecutor<ScreenSeatType> {

}