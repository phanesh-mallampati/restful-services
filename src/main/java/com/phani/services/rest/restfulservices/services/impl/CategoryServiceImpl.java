package com.phani.services.rest.restfulservices.services.impl;

import com.phani.services.rest.restfulservices.clientDTO.CategoryDTO;
import com.phani.services.rest.restfulservices.domain.Category;
import com.phani.services.rest.restfulservices.mapper.CategoryMapper;
import com.phani.services.rest.restfulservices.repositories.CategoryRepository;
import com.phani.services.rest.restfulservices.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryMapper categoryMapper;
    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryMapper categoryMapper, CategoryRepository categoryRepository) {
        this.categoryMapper = categoryMapper;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(categoryMapper::categoryToCategoryDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDTO getCategoryById(Long categoryId) {
            return categoryMapper.categoryToCategoryDTO(categoryRepository.findById(categoryId).get());
    }

    @Override
    public CategoryDTO getCategoryByName(String categoryName) {
        return categoryMapper.categoryToCategoryDTO(categoryRepository.findCategoryByName(categoryName));
    }

    @Override
    public CategoryDTO addNewCategory(CategoryDTO categoryDTO) {
        Category category = categoryRepository.save(categoryMapper.categoryDTOToCategory(categoryDTO));
        return categoryMapper.categoryToCategoryDTO(category);
    }
}
