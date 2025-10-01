package ra.edu.session_04.controller;

import ra.edu.session_04.model.dto.CategoryDTO;
import ra.edu.session_04.model.entity.Category;
import ra.edu.session_04.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @PostMapping("/add")
    public String saveCategory(@RequestBody CategoryDTO categoryDTO){
        return categoryService.saveCategory(categoryDTO);
    }

    @PutMapping("/edit/{id}")
    public String updateCategory(@PathVariable long id ,@RequestBody CategoryDTO categoryDTO){
        return categoryService.updateCategory(categoryDTO,id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCategory(@PathVariable long id){
        return categoryService.deleteCategoryById(id);
    }
}

