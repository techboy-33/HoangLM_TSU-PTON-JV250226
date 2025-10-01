package ra.edu.session_04.controller;

import ra.edu.session_04.model.dto.ProductDTO;
import ra.edu.session_04.model.entity.Product;
import ra.edu.session_04.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getProducts(){
        return productService.findAll();
    }

    @PostMapping("/add")
    public String addProduct(@RequestBody ProductDTO productDTO){
        return productService.save(productDTO);
    }

    @PutMapping("/edit/{id}")
    public String updateProduct(@PathVariable long id ,@RequestBody ProductDTO productDTO){
        return productService.update(productDTO,id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable long id){
        return productService.delete(id);
    }
}
