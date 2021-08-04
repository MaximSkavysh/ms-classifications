package com.lobster.presenter.rest.controller.country;

import com.lobster.core.usecase.country.CreateCountryUseCase;
import com.lobster.core.usecase.country.UpdateCountryUseCase;
import com.lobster.presenter.rest.entities.CountryRequest;

public final class CreateCountryInputMapper {
    CreateCountryInputMapper() {
    }
    public static CreateCountryUseCase.InputValues map(CountryRequest countryRequest) {
        return new CreateCountryUseCase.InputValues(countryRequest.getId(), countryRequest.getIdentifier(), countryRequest.getName());
    }
    public static UpdateCountryUseCase.InputValues mapUpdate(CountryRequest countryRequest) {
        return new UpdateCountryUseCase.InputValues(countryRequest.getId(), countryRequest.getIdentifier(), countryRequest.getName());
    }
}
