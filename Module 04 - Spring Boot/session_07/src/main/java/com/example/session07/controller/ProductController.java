package com.example.session07.controller;

import com.example.session07.model.dto.ProductDTO;
import com.example.session07.model.entity.Product;
import com.example.session07.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        return ResponseEntity.ok(productService.findAll());
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody ProductDTO productDTO) {
        Product product = productService.save(productDTO);
        if (product == null) {
            return new ResponseEntity<>("add product failed", HttpStatus.BAD_REQUEST);
        }else {
            return new ResponseEntity<>(product, HttpStatus.CREATED);
        }
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> edit(@RequestBody ProductDTO productDTO, @PathVariable int id) {
        Product product = productService.update(id, productDTO);
        if (product == null) {
            return new ResponseEntity<>("edit product failed", HttpStatus.BAD_REQUEST);
        }else {
            return new ResponseEntity<>(product, HttpStatus.OK);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        boolean rs  = productService.deleteById(id);
        if (rs) {
            return new ResponseEntity<>("delete product success",HttpStatus.OK);
        }else {
            return new ResponseEntity<>("delete product failed",HttpStatus.BAD_REQUEST);
        }
    }
}
