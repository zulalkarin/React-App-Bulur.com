package com.project.webApp.services;

import com.project.webApp.entity.Category;
import com.project.webApp.repos.CategoryRepo;
import com.project.webApp.requests.CategoryCreateRequest;
import com.project.webApp.requests.CategoryUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private CategoryRepo categoryRepo;

    public CategoryService(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }

    public Category getOneCategory(Long id) {
        Optional<Category> category = categoryRepo.findById(id);
        if(category.isPresent()){
            return category.get();
        }
        else return null;
    }



    public Category createOneCategory(CategoryCreateRequest request) {
        Category category =new Category();
        category.setId(request.getId());
        category.setTitle(request.getTitle());
        return categoryRepo.save(category);
    }

    public Category updateOneCategory(Long id, CategoryUpdateRequest request) {
        Optional<Category> category =categoryRepo.findById(id);
        if(category.isPresent()){
            category.get().setTitle(request.getTitle());
            return categoryRepo.save(category.get());
        }
        return null;
    }

    public void deleteOneCategory(Long id) {
        Optional<Category> category = categoryRepo.findById(id);
        if (category.isPresent()){
            categoryRepo.deleteById(id);
        }
    }



}
