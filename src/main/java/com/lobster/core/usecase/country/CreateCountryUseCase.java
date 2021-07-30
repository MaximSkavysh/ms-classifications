package com.lobster.core.usecase.country;

import com.lobster.core.domain.Country;
import com.lobster.core.usecase.UseCase;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.util.Map;

@RequiredArgsConstructor
public class CreateCountryUseCase extends UseCase<CreateCountryUseCase.InputValues, CreateCountryUseCase.OutputValues> {
    private final CountryRepository repository;

    @Override
    public OutputValues execute(InputValues input) {
        Country country = Country.newInstance(
                input.getId(),
                input.getIdentifier(),
                input.getName()
        );
        return new OutputValues(repository.persist(country));
    }

    @Value
    public static class InputValues implements UseCase.InputValues {
        Long id;
        String identifier;
        Map<String, String> name;
    }

    @Value
    public static class OutputValues implements UseCase.OutputValues {
        Country country;
    }
}
