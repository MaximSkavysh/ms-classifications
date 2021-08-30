package com.lobster.data.jpa.repository.category;

import com.lobster.core.domain.Category;
import com.lobster.core.usecase.category.CategoryRepository;
import com.lobster.data.jpa.entity.CategoryData;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class CategoryRepositoryImpl implements CategoryRepository {

    private final CategoryJpaRepository repository;

    @Override
    public List<Category> getAll() {
        return repository.findAll()
                .stream()
                .map(CategoryData::fromThis)
                .collect(Collectors.toList());
    }

    @Override
    public Category persist(Category category) {
        final CategoryData categoryData = CategoryData.from(category);
        return repository.save(categoryData).fromThis();
    }

    @Override
    public Optional<Category> findById(Long id) {
        Optional<CategoryData> categoryData = repository.findById(id);
        return categoryData.map(CategoryData::fromThis);
    }

    @Override
    public Page<Category> getAll(Pageable pageable) {
        return new PageImpl<>(repository.findAll(pageable)
                .stream()
                .map(CategoryData::fromThis)
                .collect(Collectors.toList())
        );
    }
}
