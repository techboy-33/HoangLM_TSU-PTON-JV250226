package com.example.session12.controller;

import com.example.session12.model.dto.request.FoodDTO;
import com.example.session12.model.dto.response.DataResponse;
import com.example.session12.model.entity.Food;
import com.example.session12.service.FoodService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/foods")
public class FoodController {
    @Autowired
    private FoodService foodService;

    @GetMapping
    public ResponseEntity<DataResponse<Page<Food>>> findAll(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "5") int size
    ){
        return foodService.findAll(PageRequest.of(page, size));
    }

    @PostMapping("/add")
    public ResponseEntity<DataResponse<?>> addFood(@Valid @RequestBody FoodDTO foodDTO){
        return foodService.addFood(foodDTO);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<DataResponse<?>> updateFood(@Valid @RequestBody FoodDTO foodDTO , @PathVariable long id){
        return foodService.updateFood(foodDTO, id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<DataResponse<String>> deleteFood(@PathVariable long id) {
        return foodService.deleteFood(id);
    }
}
