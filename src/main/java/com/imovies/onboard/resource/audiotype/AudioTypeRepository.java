package com.imovies.onboard.resource.audiotype;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AudioTypeRepository extends JpaRepository<AudioType, String>, JpaSpecificationExecutor<AudioType> {

}