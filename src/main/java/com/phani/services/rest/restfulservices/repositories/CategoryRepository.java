package com.phani.services.rest.restfulservices.repositories;

import com.phani.services.rest.restfulservices.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findCategoryByName(String name);
}
