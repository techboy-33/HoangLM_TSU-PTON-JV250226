package com.example.session7.service;

import com.example.session7.model.Product;
import com.example.session7.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Product findById(Long id) {
        return productRepository.findById(id);
    }

    @Transactional
    public boolean save(Product product) {
        return productRepository.save(product);
    }

    @Transactional
    public boolean deleteById(Long id) {
        return productRepository.deleteById(id);
    }

    @Transactional
    public boolean checkProductNameExists(String productName) {
        return productRepository.checkProductNameExists(productName);
    }

}
