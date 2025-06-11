package com.chouket370.personal_expense_tracker;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;
    private final UserService userService;

    public CategoryController(CategoryService categoryService, UserService userService) {
        this.categoryService = categoryService;
        this.userService = userService;
    }

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Integer id) {
        return categoryService.getCategoriesById(id);
    }

    @GetMapping("/name/{name}")
    public Category getCategoryByName(@PathVariable String name) {
        return categoryService.getCategoriesByName(name);
    }

    @PostMapping("/save")
    public CategoryDTO saveCategory(@RequestBody CategoryCreateRequest request) {
        // ERREUR CORRIGÉE: Création d'une requête séparée et récupération de l'utilisateur
        Optional<User> user = userService.getUserById(request.getUserId());
        Category category = new Category(request.getName(), user.orElse(null));
        Category saved = categoryService.saveCategory(category);
        return new CategoryDTO(saved);
    }


    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Integer id) {
        categoryService.deleteCategory(id);
    }

    @GetMapping("/user/{userId}")
    public List<CategoryDTO> getCategoriesByUserId(@PathVariable Integer userId) {
        List<Category> categories = categoryService.getCategoriesByUserId(userId);
        return categories.stream()
                .map(CategoryDTO::new)
                .collect(Collectors.toList());


    }

}