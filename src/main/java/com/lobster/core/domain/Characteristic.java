package com.lobster.core.domain;

import com.lobster.enums.CharacteristicType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class Characteristic {
    private Long id;
    private @NotBlank String identifier;
    private Map<String, String> name;
    private CharacteristicType characteristicType;
}
