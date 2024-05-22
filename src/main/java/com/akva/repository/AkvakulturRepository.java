package com.akva.repository;

import com.akva.model.Akvakultur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AkvakulturRepository extends JpaRepository<Akvakultur, Long> {
    Akvakultur findByOrgNumber(String orgNumber);
}
