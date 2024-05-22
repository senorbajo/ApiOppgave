package com.akva.repository;

import com.akva.domain.Akvakultur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AkvakulturRepository extends JpaRepository<Akvakultur, String> {
    Akvakultur findByOrgNumber(String orgNumber);
}
