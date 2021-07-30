package com.lobster.core.usecase.country;

import com.lobster.core.domain.Country;

import java.util.List;
import java.util.Optional;

public interface CountryRepository {
    List<Country> getAll();

    Optional<Country> getById(Long id);

    Country persist(Country country);
}
