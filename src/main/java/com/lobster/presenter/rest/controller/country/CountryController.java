package com.lobster.presenter.rest.controller.country;

import com.lobster.core.usecase.UseCaseExecutor;
import com.lobster.core.usecase.country.CreateCountryUseCase;
import com.lobster.core.usecase.country.GetAllCountriesUseCase;
import com.lobster.dto.ResponseDto;
import com.lobster.handler.ResponseHandler;
import com.lobster.presenter.rest.entities.CountryRequest;
import com.lobster.presenter.rest.entities.CountryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Component
@RequiredArgsConstructor
public class CountryController implements CountryResource {
    private final UseCaseExecutor useCaseExecutor;
    private final CreateCountryUseCase createCountryUseCase;
    private final GetAllCountriesUseCase getAllCountriesUseCase;

    @Override
    public CompletableFuture<ResponseDto<CountryResponse>> createCountry(CountryRequest countryRequest) {
        return useCaseExecutor.execute(createCountryUseCase, CreateCountryInputMapper.map(countryRequest),
                outputValues -> ResponseHandler.execute(() ->
                        CountryResponse.from(outputValues.getCountry()), HttpStatus.CREATED)
        );
    }

    @Override
    public CompletableFuture<ResponseDto<List<CountryResponse>>> getAllCountries() {
        return useCaseExecutor.execute(getAllCountriesUseCase,
                new GetAllCountriesUseCase.InputValues(),
                outputValues -> ResponseHandler.execute(() ->
                        CountryResponse.from(outputValues.getCountries()), HttpStatus.OK)
        );
    }
}
