package com.microtech.service.impl;

import com.microtech.model.Category;
import com.microtech.repository.CategoryRepo;
import com.microtech.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepo categoryRepo;

    @Override
    public List<Category> getAllCategory() {
        return categoryRepo.findAll();
    }

    @Override
    public void updateCategory(Category category) {
        categoryRepo.save(category);
    }

    @Override
    public void removeCategoryById(int id) {
        categoryRepo.deleteById(id);
    }

    @Override
    public Optional<Category> getCategoryById(int id) {
        return categoryRepo.findById(id);
    }
}
