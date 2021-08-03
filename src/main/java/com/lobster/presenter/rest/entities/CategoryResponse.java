package com.lobster.presenter.rest.entities;

import com.lobster.core.domain.Category;
import lombok.Value;

import java.util.Map;

@Value
public class CategoryResponse {
    Long id;
    String identifier;
    Map<String, String> name;
    boolean usedForTemplate;

    public static CategoryResponse from(Category category) {
        return new CategoryResponse(
                category.getId(),
                category.getIdentifier(),
                category.getName(),
                category.isUsedForTemplate());
    }
}
