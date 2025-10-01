package ra.edu.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.edu.exception.NotFoundException;
import ra.edu.model.entity.Category;
import ra.edu.service.ICategoryService;

import java.util.List;

@RestController // trả về JSON thay vì view
@RequiredArgsConstructor
@RequestMapping("/api/categories")
public class CategoryController {
    private final ICategoryService categoryService;
    // lấy danh sách
    @GetMapping
    public ResponseEntity<Page<Category>> getAllCategories(@PageableDefault(page = 0, size = 2) Pageable pageable){
        return new ResponseEntity<>(categoryService.getAll(pageable), HttpStatus.OK);
    }
    // lấy theo id
    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable String id) {
        try {
            return new ResponseEntity<>(categoryService.getById(id), HttpStatus.OK);// 200
        }catch (NotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);// 404
        }
    }

    // thêm mới
    @PostMapping
    public ResponseEntity<Category> createCategory(@Valid @RequestBody Category category){
        return new ResponseEntity<>(categoryService.create(category), HttpStatus.CREATED); // 201
    }
    // cập nhật
    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable String id, @Valid @RequestBody Category category){
        try{
            return new ResponseEntity<>(categoryService.update(id, category), HttpStatus.OK); // 200
        }catch (NotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);// 404
        }
    }
    // xóa
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable String id){
        try {
            categoryService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204
        }catch (NotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);// 404
        }
    }
}
