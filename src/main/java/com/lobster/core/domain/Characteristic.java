package com.lobster.core.domain;

import com.lobster.core.usecase.characteristic.CreateCharacteristicUseCase;
import com.lobster.enums.CharacteristicType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.Map;
import java.util.stream.Stream;

@Getter
@Setter
@AllArgsConstructor
public class Characteristic {
    private Long id;
    private @NotBlank String identifier;
    private Map<String, String> name;
    private CharacteristicType characteristicType;

    public static Characteristic newInstance(CreateCharacteristicUseCase.InputValues input) {
        return new Characteristic(input.getId(),
                input.getIdentifier(),
                input.getName(),
                getType(input.getCharacteristicType())
        );
    }

    private static CharacteristicType getType(String type) {
        return Stream.of(CharacteristicType.values())
                .filter(charType -> charType.toString().equals(type))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("unknown value: " + type));
    }
}
