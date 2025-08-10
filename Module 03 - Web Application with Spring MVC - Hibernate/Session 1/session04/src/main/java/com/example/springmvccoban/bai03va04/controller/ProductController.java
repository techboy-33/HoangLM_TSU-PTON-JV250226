package com.example.springmvccoban.bai03va04.controller;

import com.example.springmvccoban.bai03va04.model.Product;
import com.example.springmvccoban.bai03va04.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public String getProducts(Model model ,
                              @RequestParam(required = false , name = "searchProductName") String searchProductName) {
        List<Product> products = productService.searchProductName(searchProductName);
        model.addAttribute("products", products);
        model.addAttribute("searchProductName", searchProductName);
        return "products";
    }
}
