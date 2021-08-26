package com.lobster.core.usecase.country;

import com.lobster.constants.Constants;
import com.lobster.core.domain.Country;
import com.lobster.core.exception.AlreadyUsedException;
import com.lobster.core.exception.NotFoundException;
import com.lobster.core.usecase.UseCase;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.util.Map;

@RequiredArgsConstructor
public class UpdateCountryUseCase implements UseCase<UpdateCountryUseCase.InputValues, UpdateCountryUseCase.OutputValues> {

    private final CountryRepository repository;

    @Override
    public OutputValues execute(InputValues input) {
        if (repository.isExistIdentifier(input.getIdentifier())) {
            throw new AlreadyUsedException(Constants.ErrorCode.ALREADY_USED.toString());
        }
        return this.repository
                .getById(input.id)
                .map(country -> updateStatus(country, input))
                .map(this::persistAndReturn)
                .orElseThrow(() -> new NotFoundException(Constants.ErrorCode.NOT_FOUND.toString()));
    }

    private Country updateStatus(Country country, InputValues inputValues) {
        return new Country(country.getId(), inputValues.getIdentifier(), inputValues.getName());
    }

    private OutputValues persistAndReturn(Country country) {
        return new OutputValues(this.repository.persist(country));
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
