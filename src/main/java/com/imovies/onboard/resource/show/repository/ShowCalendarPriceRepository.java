package com.imovies.onboard.resource.show.repository;

import com.imovies.onboard.resource.show.entity.ShowCalendarPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ShowCalendarPriceRepository extends JpaRepository<ShowCalendarPrice, Integer>, JpaSpecificationExecutor<ShowCalendarPrice> {

}