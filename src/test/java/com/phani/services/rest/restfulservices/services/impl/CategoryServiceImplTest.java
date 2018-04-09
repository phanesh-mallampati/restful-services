package com.phani.services.rest.restfulservices.services.impl;

import com.phani.services.rest.restfulservices.clientDTO.CategoryDTO;
import com.phani.services.rest.restfulservices.domain.Category;
import com.phani.services.rest.restfulservices.mapper.CategoryMapper;
import com.phani.services.rest.restfulservices.repositories.CategoryRepository;
import com.phani.services.rest.restfulservices.services.CategoryService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class CategoryServiceImplTest {

    public static final Long ID = 2L;
    public static final String NAME = "Development";
    CategoryService categoryService;

    @Mock
    private CategoryRepository categoryRepository;

//    @Mock
//    CategoryMapperImpl categoryMapper;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        categoryService = new CategoryServiceImpl(CategoryMapper.INSTANCE, categoryRepository);
    }

    @Test
    public void getAllCategoriesTest() {
        Category category1 = new Category();
        Category category2 = new Category();
        List<Category> categoriesList = new ArrayList<>();
        categoriesList.add(category1);
        categoriesList.add(category2);

        when(categoryRepository.findAll()).thenReturn(categoriesList);

        List<CategoryDTO> categoryDTOList = categoryService.getAllCategories();

        assertEquals(2, categoryDTOList.size());
    }

    @Test
    public void getCategoryByNameTest() {
        Category category = new Category();
        category.setId(ID);
        category.setName(NAME);

        when(categoryRepository.findCategoryByName(anyString())).thenReturn(category);
        CategoryDTO categoryDTO = categoryService.getCategoryByName(NAME);
        assertEquals(ID, categoryDTO.getId());
        verify(categoryRepository, times(1)).findCategoryByName(anyString());
    }

    @Test
    public void addCategoryTest(){
        Category category = new Category();
        category.setName(NAME);

        when(categoryRepository.save(any(Category.class))).thenReturn(category);

        CategoryDTO newCategoryDTO = new CategoryDTO();
        newCategoryDTO.setName(NAME);
        CategoryDTO categoryDTO = categoryService.addNewCategory(newCategoryDTO);
        assertEquals(newCategoryDTO.getName(),categoryDTO.getName());
        verify(categoryRepository, times(1)).save(any(Category.class));
    }
}