package com.example.session08;

import com.example.session08.model.Category;

public class Main {
    public static void main(String[] args) {
        Category category = Category
                .builder()
                .id(1L)
                .cateName("Đồ gia dụng")
                .description("ngon bổ rẻ")
                .status(true)
                .build();
    }
}
