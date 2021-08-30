package com.lobster.core.usecase.category;

import com.lobster.core.domain.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository {
    List<Category> getAll();

    Category persist(Category category);

    Optional<Category> findById(Long id);

    Page<Category> getAll(Pageable pageable);
}
