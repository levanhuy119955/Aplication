package com.tmt.exception.controller;

import com.tmt.exception.exceptionentity.CategoryExceptionEntity;
import com.tmt.exception.entity.Category;
import com.tmt.exception.global.CategoryExceptionGolbal;
import com.tmt.exception.reposiotry.CategoryRepository;
import com.tmt.exception.service.CategoryService;
import com.tmt.exception.servicesimpl.CategoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v1/api/category")
public class CategoryController {
    @Autowired
    CategoryRepository caterepo;

    @Autowired
    CategoryService categoryService;


    // chạy api này trước
    @PostMapping("creat")
    public Category creatCategory(@RequestBody Category category){
        Category categories = caterepo.save(category);
        return categories;
    }

    @GetMapping("get/{id}")
    public Category getByID(@PathVariable Integer id){
    Optional<Category> category = caterepo.findById(id);
    Category checkName = caterepo.findByCategoryName(category.get().getCategoryName());
        if (checkName.getCategoryName().length() <= 5){
            throw new CategoryExceptionGolbal("");
        }
       return category.get();
    }

    @PostMapping("/creatTwo")
    public ResponseEntity<Category> creatCategoryTwo (@RequestBody Category cate){
        Category category = categoryService.creatCategory(cate);
        return ResponseEntity.ok(category);
    }


}
