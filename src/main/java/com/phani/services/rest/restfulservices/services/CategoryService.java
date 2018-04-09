package com.phani.services.rest.restfulservices.services;

import com.phani.services.rest.restfulservices.clientDTO.CategoryDTO;

import java.util.List;

public interface CategoryService {

    List<CategoryDTO> getAllCategories();

    CategoryDTO getCategoryById(Long categoryId);

    CategoryDTO getCategoryByName(String categoryName);

    CategoryDTO addNewCategory(CategoryDTO categoryDTO);
}
