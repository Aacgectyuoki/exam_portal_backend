package com.project.examportal.service;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.examportal.model.exam.Category;
import com.project.examportal.repository.CategoryRepository;


@Service
public class CategoryService {
	
	@Autowired
    private CategoryRepository categoryRepository;
	
    public Category addCategory(Category category) {
        return this.categoryRepository.save(category);
    }

    public Category updateCategory(Category category) {
        return this.categoryRepository.save(category);
    }

    public Set<Category> getCategories() {
        return new LinkedHashSet<>(this.categoryRepository.findAll());
    }

    
    public Category getCategory(Long categoryId) {
        return this.categoryRepository.findById(categoryId).get();
    }

    
    public void deleteCategory(Long categoryId) {
        Category category = new Category();
        category.setCid(categoryId);
        this.categoryRepository.delete(category);
    }

}
