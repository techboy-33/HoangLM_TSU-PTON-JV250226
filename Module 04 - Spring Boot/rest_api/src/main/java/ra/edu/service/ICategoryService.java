package ra.edu.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ra.edu.exception.NotFoundException;
import ra.edu.model.entity.Category;

import java.util.List;

public interface ICategoryService {
    Page<Category> getAll(Pageable pageable);
    Category getById(String id) throws NotFoundException;
    Category create(Category category);
    Category update(String id, Category category) throws NotFoundException;
    void deleteById(String id) throws NotFoundException;
}
