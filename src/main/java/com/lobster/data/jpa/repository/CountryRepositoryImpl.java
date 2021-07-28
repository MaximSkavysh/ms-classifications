package com.lobster.data.jpa.repository;

import com.lobster.core.domain.Country;
import com.lobster.core.usecase.country.CountryRepository;
import com.lobster.data.jpa.entity.CountryData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class CountryRepositoryImpl implements CountryRepository {

    private final JpaCountryRepository repository;

    @Override
    public List<Country> getAll() {
        return repository
                .findAll()
                .stream()
                .map(CountryData::fromThis)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Country> getById(Long id) {
        return Optional.empty();
    }
}
