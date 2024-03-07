package com.hdtech.HDTech_E_Learning.Service;

import com.hdtech.HDTech_E_Learning.Entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CategoryService {
    Category addCategory(Category category);

    Optional<Category> findById(long id);

    Page<Category> findByName(String keyword, Pageable pageable);
}
