package com.lobster.data.jpa.repository;

import com.lobster.data.jpa.entity.CountryData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCountryRepository extends JpaRepository<CountryData, Long> {
}
