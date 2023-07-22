package com.imovies.onboard.resource.language;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface LanguageRepository extends JpaRepository<Language, String>, JpaSpecificationExecutor<Language> {

}