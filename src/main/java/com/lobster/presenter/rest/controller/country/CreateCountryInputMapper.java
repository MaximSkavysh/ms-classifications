package com.lobster.presenter.rest.controller.country;

import com.lobster.core.usecase.country.CreateCountryUseCase;
import com.lobster.presenter.rest.entities.CountryRequest;

public final class CreateCountryInputMapper {
    CreateCountryInputMapper() {
    }
    public static CreateCountryUseCase.InputValues map(CountryRequest countryRequest) {
        return new CreateCountryUseCase.InputValues(countryRequest.getId(), countryRequest.getIdentifier(), countryRequest.getName());
    }
}
