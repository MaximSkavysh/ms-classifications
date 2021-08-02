package com.lobster.core.usecase.category;

import com.lobster.core.domain.Category;
import com.lobster.core.domain.Characteristic;
import com.lobster.core.usecase.UseCase;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.util.Map;
import java.util.Set;

@RequiredArgsConstructor
public class CreateCategoryUseCase implements UseCase<CreateCategoryUseCase.InputValues, CreateCategoryUseCase.OutputValues> {

    private final CategoryRepository repository;

    @Override
    public OutputValues execute(InputValues input) {
        Category category = Category.newInstance(input);
        return new CreateCategoryUseCase.OutputValues(repository.persist(category));
    }

    @Value
    public static class InputValues implements UseCase.InputValues {
        Long id;
        String identifier;
        Map<String, String> name;
        boolean usedForTemplate;
        Set<Characteristic> characteristics;
    }

    @Value
    public static class OutputValues implements UseCase.OutputValues {
        Category category;
    }
}
