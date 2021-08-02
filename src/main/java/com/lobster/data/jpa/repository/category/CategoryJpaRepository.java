package com.lobster.data.jpa.repository.category;

import com.lobster.data.jpa.entity.CategoryData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryJpaRepository extends JpaRepository<CategoryData, Long> {
}
