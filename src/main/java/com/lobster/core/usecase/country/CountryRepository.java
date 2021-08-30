package com.lobster.core.usecase.country;

import com.lobster.core.domain.Country;
import com.lobster.core.usecase.base.BaseRepository;

import java.util.List;
import java.util.Optional;

public interface CountryRepository extends BaseRepository {
    List<Country> getAll();

    Optional<Country> findById(Long id);

    Country persist(Country country);

}
