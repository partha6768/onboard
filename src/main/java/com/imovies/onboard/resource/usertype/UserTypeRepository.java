package com.imovies.onboard.resource.usertype;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserTypeRepository extends JpaRepository<UserType, String>, JpaSpecificationExecutor<UserType> {

}