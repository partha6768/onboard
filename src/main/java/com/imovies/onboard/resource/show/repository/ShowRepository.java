package com.imovies.onboard.resource.show.repository;

import com.imovies.onboard.resource.show.entity.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ShowRepository extends JpaRepository<Show, Integer>, JpaSpecificationExecutor<Show> {

}