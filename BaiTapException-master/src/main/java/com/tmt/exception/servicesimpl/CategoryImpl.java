package com.tmt.exception.servicesimpl;

import com.tmt.exception.entity.Category;
import com.tmt.exception.reposiotry.CategoryRepository;
import com.tmt.exception.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class CategoryImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;



    @Override
    public Category creatCategory(Category categoryNew) {
        Category category = categoryRepository.save(categoryNew);
        return category;
    }



}
