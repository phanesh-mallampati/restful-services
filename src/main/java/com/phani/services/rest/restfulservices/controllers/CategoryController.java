package com.phani.services.rest.restfulservices.controllers;

import com.phani.services.rest.restfulservices.clientDTO.CategoryDTO;
import com.phani.services.rest.restfulservices.clientDTO.CategoryListDTO;
import com.phani.services.rest.restfulservices.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.phani.services.rest.restfulservices.controllers.CategoryController.BASE_URL;

@RestController
@RequestMapping(BASE_URL)
public class CategoryController {

    public static final String BASE_URL = "/rest/category";

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<CategoryListDTO> getCategories(){
        CategoryListDTO categoryListDTO = new CategoryListDTO();
        categoryListDTO.setData(categoryService.getAllCategories());
        return new ResponseEntity<CategoryListDTO>(categoryListDTO, HttpStatus.OK);
    }

    @GetMapping("{name}")
    public ResponseEntity<CategoryDTO> getCategoryByName(@PathVariable String name){
        CategoryDTO categoryDTO = categoryService.getCategoryByName(name);
        if(null == categoryDTO){
            return new ResponseEntity<>(new CategoryDTO(), HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(categoryDTO, HttpStatus.OK);
        }
    }
}
