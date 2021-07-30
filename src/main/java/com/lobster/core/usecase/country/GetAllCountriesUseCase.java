package com.lobster.core.usecase.country;

import com.lobster.core.domain.Country;
import com.lobster.core.usecase.UseCase;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.util.List;

@RequiredArgsConstructor
public class GetAllCountriesUseCase extends UseCase<GetAllCountriesUseCase.InputValues, UseCase.OutputValues> {

    private final CountryRepository repository;

    @Override
    public OutputValues execute(InputValues input) {
        return new OutputValues(repository.getAll());
    }

    @Value
    public static class InputValues implements UseCase.InputValues {
    }

    @Value
    public static class OutputValues implements UseCase.OutputValues {
        List<Country> products;
    }
}
