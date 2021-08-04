package com.lobster.core.usecase.country;

import com.lobster.constants.Constants;
import com.lobster.core.domain.Country;
import com.lobster.core.exception.NotFoundException;
import com.lobster.core.usecase.UseCase;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.util.Optional;


@RequiredArgsConstructor
public class GetCountryUseCase implements UseCase<GetCountryUseCase.InputValues, GetCountryUseCase.OutputValues> {
    private final CountryRepository repository;

    @Override
    public OutputValues execute(InputValues input) {
        Optional<Country> country = repository.getById(input.id);
        return new OutputValues(country.orElseThrow(() -> new NotFoundException(Constants.ErrorCode.NOT_FOUND.toString())));
    }


    @Value
    public static class InputValues implements UseCase.InputValues {
        Long id;
    }

    @Value
    public static class OutputValues implements UseCase.OutputValues {
        Country country;
    }
}
