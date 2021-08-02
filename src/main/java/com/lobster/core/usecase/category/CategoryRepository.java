package com.lobster.core.usecase.category;

import com.lobster.core.domain.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryRepository {
    List<Category> getAll();

    Category persist(Category category);

    Page<Category> getAll(Pageable pageable);
}
