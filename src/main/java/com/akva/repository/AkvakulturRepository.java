package com.akva.repository;

import com.akva.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AkvakulturRepository extends JpaRepository<Organization, Long> {
    Organization findByOrgNumber(String orgNumber);
}
