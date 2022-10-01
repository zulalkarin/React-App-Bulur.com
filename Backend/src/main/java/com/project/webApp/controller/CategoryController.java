package com.project.webApp.controller;

import com.project.webApp.entity.Category;
import com.project.webApp.requests.CategoryCreateRequest;
import com.project.webApp.requests.CategoryUpdateRequest;
import com.project.webApp.responses.CompanyResponse;
import com.project.webApp.services.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public Category getOnecategory(@PathVariable Long id){
        return categoryService.getOneCategory(id);
    }



    @PostMapping
    public Category createOneCategory(@RequestBody CategoryCreateRequest request){
        return categoryService.createOneCategory(request);
    }

    @PutMapping("/{id}")
    public Category updateOneCategory(@PathVariable Long id, @RequestBody CategoryUpdateRequest request){
        return categoryService.updateOneCategory(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteOneCategory(@PathVariable Long id){
        categoryService.deleteOneCategory(id);
    }
}
