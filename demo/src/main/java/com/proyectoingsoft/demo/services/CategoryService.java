package com.proyectoingsoft.demo.services;

import com.proyectoingsoft.demo.models.Category;
import com.proyectoingsoft.demo.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    // Método para obtener todas las categorías
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    // Método para obtener una categoría por su ID
    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    // Método para crear una nueva categoría
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    // Método para eliminar una categoría por su ID
    public void deleteCategory(Long id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Category with ID " + id + " does not exist.");
        }
    }
}
