package com.lobster.presenter.rest.controller.country;

import com.lobster.core.domain.Country;
import com.lobster.dto.ResponseDto;
import com.lobster.presenter.rest.entities.CountryResponse;
import org.springframework.http.HttpStatus;

import java.util.List;

public final class CreateCountryOutputMapper {
    private CreateCountryOutputMapper() {
    }

    public static ResponseDto<CountryResponse> map(Country country) {
        return ResponseDto.<CountryResponse>builder()
                .data(new CountryResponse(country.getId(), country.getIdentifier(), country.getName()))
                .status(HttpStatus.CREATED)
                .build();
    }

    public static ResponseDto<List<CountryResponse>> map(List<CountryResponse> countries) {
        return ResponseDto.<List<CountryResponse>>builder()
                .data(countries)
                .status(HttpStatus.OK)
                .build();
    }
}
