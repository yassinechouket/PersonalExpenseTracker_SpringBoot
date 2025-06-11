package com.chouket370.personal_expense_tracker;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;


    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
    public Category getCategoriesById(Integer id) {
        return categoryRepository.findById(id).orElseThrow(() -> new IllegalStateException(id + " not found"));
    }
    public Category saveCategory(Category category) {
        if (category.getUser() == null) {
            throw new IllegalArgumentException("Category must have a user");
        }
        return categoryRepository.save(category);
    }
    public  void deleteCategory(Integer id) {
        categoryRepository.deleteById(id);
    }

    public Category getCategoriesByName(String name) {
        return categoryRepository.findByName(name);
    }
    public List<Category> getCategoriesByUserId(Integer userId) {
        return categoryRepository.findByUserId(userId);
    }
}
