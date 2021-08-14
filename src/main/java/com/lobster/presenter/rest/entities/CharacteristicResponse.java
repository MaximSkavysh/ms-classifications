package com.lobster.presenter.rest.entities;

import com.lobster.core.domain.Characteristic;
import com.lobster.enums.CharacteristicType;
import lombok.Value;

import java.util.Map;

@Value
public class CharacteristicResponse {
    Long id;
    String identifier;
    Map<String, String> name;
    CharacteristicType characteristicType;

    public static CharacteristicResponse from(Characteristic characteristic) {
        return new CharacteristicResponse(characteristic.getId(),
                characteristic.getIdentifier(),
                characteristic.getName(),
                characteristic.getCharacteristicType()
        );
    }
}
