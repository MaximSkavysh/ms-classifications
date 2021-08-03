package com.lobster.presenter.rest.controller.category;

import com.lobster.dto.ResponseDto;
import com.lobster.presenter.rest.entities.CategoryRequest;
import com.lobster.presenter.rest.entities.CategoryResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(value = "/api/classification/category")
public interface CategoryResource {

    @PostMapping
    CompletableFuture<ResponseDto<CategoryResponse>> createCategory(@RequestBody CategoryRequest countryRequest);
}
