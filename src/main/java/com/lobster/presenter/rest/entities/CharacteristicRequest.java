package com.lobster.presenter.rest.entities;

import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Map;

@Value
public class CharacteristicRequest {
    Long id;
    @NotNull
    @NotBlank
    @Size(min = 2, max = 20)
    String identifier;
    Map<String, String> name;
    String characteristicType;
}
