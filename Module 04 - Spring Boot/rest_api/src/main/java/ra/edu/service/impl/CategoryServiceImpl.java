package ra.edu.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ra.edu.exception.NotFoundException;
import ra.edu.model.entity.Category;
import ra.edu.repository.ICategoryRepository;
import ra.edu.service.ICategoryService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements ICategoryService {
    private final ICategoryRepository categoryRepository; // tương tự autowired : constructor injection
    @Override
    public Page<Category> getAll(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    @Override
    public Category getById(String id) throws NotFoundException{
        return categoryRepository.findById(id).orElseThrow(() -> new NotFoundException("Category not found with id: " + id));
    }

    @Override
    public Category create(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category update(String id, Category category) throws NotFoundException {
        Category old = categoryRepository.findById(id).orElseThrow(() -> new NotFoundException("Category not found with id: " + id));
        old.setCategoryName(category.getCategoryName());
        old.setDescription(category.getDescription());
        return categoryRepository.save(old);
    }

    @Override
    public void deleteById(String id) throws NotFoundException {
        if (categoryRepository.existsById(id)){
            categoryRepository.deleteById(id);
        }else {
            throw new NotFoundException("Category not found with id: " + id);
        }
    }
}
