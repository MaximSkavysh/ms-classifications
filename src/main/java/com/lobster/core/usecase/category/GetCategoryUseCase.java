package com.lobster.core.usecase.category;

import com.lobster.constants.Constants;
import com.lobster.core.domain.Category;
import com.lobster.core.exception.NotFoundException;
import com.lobster.core.usecase.UseCase;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.util.Optional;

@RequiredArgsConstructor
public class GetCategoryUseCase implements UseCase<GetCategoryUseCase.InputValues, GetCategoryUseCase.OutputValues> {

    private final CategoryRepository repository;

    @Override
    public OutputValues execute(InputValues input) {
        Optional<Category> category = repository.findById(input.getId());
        return new GetCategoryUseCase.OutputValues(category.orElseThrow(() -> new NotFoundException(Constants.ErrorCode.NOT_FOUND.toString())));

    }

    @Value
    public static class InputValues implements UseCase.InputValues {
        Long id;
    }

    @Value
    public static class OutputValues implements UseCase.OutputValues {
        Category category;
    }
}
