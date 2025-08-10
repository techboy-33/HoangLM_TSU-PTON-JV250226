package com.example.springmvccoban.bai03va04.service;

import com.example.springmvccoban.bai03va04.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final List<Product> products = new ArrayList<>(Arrays.asList(
            new Product(1, "Khoai tây", 15000, 50, "Ngon"),
            new Product(2, "Cà rốt", 12000, 30, "Giòn"),
            new Product(3, "Hành tây", 20000, 40, "Ngọt"),
            new Product(4, "Ớt chuông", 25000, 20, "Thơm"),
            new Product(5, "Bắp cải", 18000, 35, "Tươi"),
            new Product(6, "Củ cải", 16000, 25, "Ngọt"),
            new Product(7, "Dưa leo", 14000, 45, "Mát"),
            new Product(8, "Cà chua", 22000, 60, "Chua"),
            new Product(9, "Rau diếp", 17000, 55, "Tươi"),
            new Product(10, "Khoai lang", 19000, 50, "Ngon")));

    public List<Product> getProducts() {
        return products;
    }

    public List<Product> searchProductName(String searchProductName) {
        if (searchProductName == null || searchProductName.isEmpty()) {
            return products;
        }else {
            return products.stream().filter(product -> product.getProductName().toLowerCase()
                    .contains(searchProductName.toLowerCase())).collect(Collectors.toList());

        }    }
}
