package com.lobster.core.domain;


import com.lobster.core.usecase.category.CreateCategoryUseCase;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.Map;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class Category {

    private Long id;
    private @NotBlank String identifier;
    private Map<String, String> name;
    private boolean usedForTemplate;
    private Set<Characteristic> characteristics;

    public static Category newInstance(CreateCategoryUseCase.InputValues input) {
        return new Category(input.getId(),
                input.getIdentifier(),
                input.getName(),
                input.isUsedForTemplate(),
                input.getCharacteristics()
        );
    }

}
