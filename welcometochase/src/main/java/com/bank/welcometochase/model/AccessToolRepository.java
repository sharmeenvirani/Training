package com.bank.welcometochase.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AccessToolRepository extends JpaRepository<AccessTool, Long> {
}
