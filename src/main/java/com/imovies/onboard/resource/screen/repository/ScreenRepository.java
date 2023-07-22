package com.imovies.onboard.resource.screen.repository;

import com.imovies.onboard.resource.screen.entity.Screen;
import com.imovies.onboard.resource.screen.entity.ScreenPk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ScreenRepository extends JpaRepository<Screen, ScreenPk>, JpaSpecificationExecutor<Screen> {

    @Query("select s from Screen s WHERE s.theaterId = :id")
    List<Screen> findAllByTheaterId(@Param("id") Integer id);
}