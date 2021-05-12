package com.ernest.productsandcategories.services;

import java.util.List;
import java.util.Optional; 

import org.springframework.stereotype.Service;

import com.ernest.productsandcategories.models.Category;
import com.ernest.productsandcategories.repositories.CategoryRepository;



@Service
public class CategoryService {
    
    private final CategoryRepository categoryRepository;
    
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    
   
    public List<Category> allCategorys() {
        return categoryRepository.findAll();
    }
    
    
    public Category createCategory(Category c) {
        return categoryRepository.save(c);
    }
    
    
    public Category findCategory(Long id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if(optionalCategory.isPresent()) {
            return optionalCategory.get();
        } else {
            return null;
        }
    }
 
}