package com.imovies.onboard.resource.movietype;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MovieTypeRepository extends JpaRepository<MovieType, String>, JpaSpecificationExecutor<MovieType> {

}