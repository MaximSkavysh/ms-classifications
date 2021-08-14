package com.lobster.core.usecase.characteristic;

import com.lobster.core.domain.Characteristic;
import com.lobster.core.usecase.UseCase;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.util.Map;

@RequiredArgsConstructor
public class CreateCharacteristicUseCase implements UseCase<CreateCharacteristicUseCase.InputValues, CreateCharacteristicUseCase.OutputValues> {

    private final CharacteristicRepository repository;

    @Override
    public OutputValues execute(InputValues input) {
        Characteristic category = Characteristic.newInstance(input);
        return new CreateCharacteristicUseCase.OutputValues(repository.persist(category));
    }

    @Value
    public static class InputValues implements UseCase.InputValues {
        Long id;
        String identifier;
        Map<String, String> name;
        String characteristicType;
    }

    @Value
    public static class OutputValues implements UseCase.OutputValues {
        Characteristic characteristic;
    }
}
