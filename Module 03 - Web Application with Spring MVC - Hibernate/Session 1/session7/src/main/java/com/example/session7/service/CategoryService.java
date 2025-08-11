package com.example.session7.service;

import com.example.session7.model.Category;
import com.example.session7.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Transactional
    public boolean save(Category category) {
        return categoryRepository.save(category);
    }

    @Transactional(readOnly = true)
    public Category findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Transactional
    public boolean deleteById(Long id) {
        return categoryRepository.delete(id);
    }

    @Transactional
    public boolean existsByCateName(String cateName) {
        return categoryRepository.existsByCateName(cateName);
    }
}
