package ra.edu.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ra.edu.exception.NotFoundException;
import ra.edu.model.dto.DataResponse;
import ra.edu.model.entity.Product;
import ra.edu.service.ICategoryService;
import ra.edu.service.IProductService;
import ra.edu.service.impl.ProductServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final IProductService productService;
    @GetMapping
    public ResponseEntity<DataResponse<List<Product>>> getAllProducts() {
        return new ResponseEntity<>(productService.getAllProducts(),HttpStatus.OK);
    }
    @GetMapping("/{id}")
     public ResponseEntity<DataResponse<Product>> getProductById(@PathVariable Long id) throws NotFoundException {
        return new ResponseEntity<>(productService.getProductById(id),HttpStatus.OK);
     }
}
