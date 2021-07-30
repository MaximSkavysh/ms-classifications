package com.lobster.presenter.rest.entities;

import com.lobster.core.domain.Country;
import lombok.Value;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Value
public class CountryResponse {
    Long id;
    String identifier;
    Map<String, String> name;


    public static CountryResponse from(Country country) {
        return new CountryResponse(
                country.getId(),
                country.getIdentifier(),
                country.getName());
    }

    public static List<CountryResponse> from(List<Country> countries) {
        return countries
                .parallelStream()
                .map(CountryResponse::from)
                .collect(Collectors.toList());
    }
}
