package com.imovies.onboard.resource.show.repository;

import com.imovies.onboard.resource.show.entity.ShowCalendar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ShowCalendarRepository extends JpaRepository<ShowCalendar, Integer>, JpaSpecificationExecutor<ShowCalendar> {

}