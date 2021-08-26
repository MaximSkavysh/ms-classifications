package com.lobster.data.jpa.repository.country;

import com.lobster.data.jpa.entity.CountryData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryJpaRepository extends JpaRepository<CountryData, Long> {
    boolean existsByIdentifier(String identifier);
}
