package com.example.session08.service;

import com.example.session08.model.Category;
import com.example.session08.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    public List<Category> findAll(int page , int size , String search) {
        int offset = (page - 1) * size;
        return categoryRepository.getAllCategories(offset,size,search);
    }

    @Transactional(readOnly = true)
    public Category findById(Long id) {
        return categoryRepository.getCategoryById(id);
    }

    @Transactional
    public Long countTotalElement(String search){
        return categoryRepository.countTotalElement(search);
    }

    @Transactional
    public boolean saveCategory(Category category) {
        return categoryRepository.saveCategory(category);
    }

    @Transactional
    public boolean updateCategory(long id ,Category category) {
        Category oldCategory = categoryRepository.getCategoryById(id);
        if (oldCategory != null) {
            category.setId(oldCategory.getId());
            return categoryRepository.updateCategory(category);
        }else {
            return false;
        }

    }

    @Transactional
    public boolean deleteCategoryById(long id) {
        return categoryRepository.deleteCategoryById(id);
    }
}
