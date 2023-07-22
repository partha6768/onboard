package com.imovies.onboard.resource.movie.repository;

import com.imovies.onboard.resource.movie.entity.MovieViewType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MovieViewTypeRepository extends JpaRepository<MovieViewType, Integer>, JpaSpecificationExecutor<MovieViewType> {

}