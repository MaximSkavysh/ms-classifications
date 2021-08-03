package com.lobster.presenter.rest.controller.category;

import com.lobster.core.usecase.category.CreateCategoryUseCase;
import com.lobster.presenter.rest.entities.CategoryRequest;

import java.util.HashSet;

public class CreateCategoryInputMapper {
    private CreateCategoryInputMapper() {
    }

    public static CreateCategoryUseCase.InputValues map(CategoryRequest categoryRequest) {
        return new CreateCategoryUseCase.InputValues(categoryRequest.getId(),
                categoryRequest.getIdentifier(),
                categoryRequest.getName(), categoryRequest.isUsedForTemplate(),
                new HashSet<>());
    }
}
