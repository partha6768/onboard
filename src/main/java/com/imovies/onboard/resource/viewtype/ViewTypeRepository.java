package com.imovies.onboard.resource.viewtype;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ViewTypeRepository extends JpaRepository<ViewType, String>, JpaSpecificationExecutor<ViewType> {

}