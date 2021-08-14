package com.lobster.presenter.rest.controller.characteristic;

import com.lobster.core.usecase.characteristic.CreateCharacteristicUseCase;
import com.lobster.presenter.rest.entities.CharacteristicRequest;

public class CreateCharacteristicInputMapper {
    private CreateCharacteristicInputMapper() {
    }

    public static CreateCharacteristicUseCase.InputValues map(CharacteristicRequest characteristicRequest) {
        return new CreateCharacteristicUseCase.InputValues(characteristicRequest.getId(),
                characteristicRequest.getIdentifier(),
                characteristicRequest.getName(),
                characteristicRequest.getCharacteristicType());
    }
}
