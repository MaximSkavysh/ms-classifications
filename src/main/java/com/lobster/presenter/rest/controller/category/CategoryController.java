package com.lobster.presenter.rest.controller.category;

import com.lobster.core.usecase.UseCaseExecutor;
import com.lobster.core.usecase.category.CreateCategoryUseCase;
import com.lobster.dto.ResponseDto;
import com.lobster.handler.ResponseHandler;
import com.lobster.presenter.rest.entities.CategoryRequest;
import com.lobster.presenter.rest.entities.CategoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
@RequiredArgsConstructor
public class CategoryController implements CategoryResource {
    private final UseCaseExecutor useCaseExecutor;
    private final CreateCategoryUseCase createCategoryUseCase;

    @Override
    public CompletableFuture<ResponseDto<CategoryResponse>> createCategory(CategoryRequest categoryRequest) {
        return useCaseExecutor.execute(createCategoryUseCase, CreateCategoryInputMapper.map(categoryRequest),
                outputValues -> ResponseHandler.execute(() ->
                        CategoryResponse.from(outputValues.getCategory()), HttpStatus.CREATED)
        );
    }
}
