package com.example.session12.service;

import com.example.session12.model.dto.request.FoodDTO;
import com.example.session12.model.dto.response.DataResponse;
import com.example.session12.model.entity.Food;
import com.example.session12.repository.FoodRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class FoodService {
    @Autowired
    private FoodRepository foodRepository;
    private final Logger logger = LoggerFactory.getLogger(FoodService.class);

    public ResponseEntity<DataResponse<Page<Food>>> findAll(Pageable pageable) {
        DataResponse<Page<Food>> dataResponse = DataResponse
                .<Page<Food>>builder()
                .message("Get all foods successful")
                .data(foodRepository.findAll(pageable))
                .status(200)
                .build();
        return ResponseEntity.status(200).body(dataResponse);
    }

    public List<Food> findAll(){
        return foodRepository.findAll();
    }

    public ResponseEntity<DataResponse<?>> addFood(FoodDTO foodDTO){
        Food food = convertFoodDTOToFood(foodDTO);
        try {
            Food newFood = foodRepository.save(food);
            DataResponse<Food> dataResponse = DataResponse
                    .<Food>builder()
                    .message("Add food successful")
                    .data(newFood)
                    .status(201)
                    .build();
            return ResponseEntity.status(201).body(dataResponse);
        } catch (Exception e) {
            logger.error(e.getMessage());
            DataResponse<?> dataResponse = DataResponse
                    .builder()
                    .message("Add food failed: " + e.getMessage())
                    .status(400)
                    .build();
            return ResponseEntity.status(400).body(dataResponse);
        }
    }

    public Food findById(long id){
        return foodRepository.findById(id).orElseThrow(()-> new NoSuchElementException("Food not found with id: " + id));
    }

    public ResponseEntity<DataResponse<?>> updateFood(FoodDTO foodDTO , long id){
        Food oldFood = findById(id);
        if (oldFood == null) {
            DataResponse<?> dataResponse = DataResponse
                    .builder()
                    .message("Food not found with id: " + id)
                    .status(404)
                    .build();
            return ResponseEntity.status(404).body(dataResponse);
        } else {
            oldFood.setFoodName(foodDTO.getFoodName());
            oldFood.setPrice(foodDTO.getPrice());
            oldFood.setDescription(foodDTO.getDescription());
            try {
                Food updatedFood = foodRepository.save(oldFood);
                DataResponse<Food> dataResponse = DataResponse
                        .<Food>builder()
                        .message("Update food successful")
                        .data(updatedFood)
                        .status(200)
                        .build();
                return ResponseEntity.status(200).body(dataResponse);
            } catch (Exception e) {
                logger.error(e.getMessage());
                DataResponse<?> dataResponse = DataResponse
                        .builder()
                        .message("Update food failed: " + e.getMessage())
                        .status(400)
                        .build();
                return ResponseEntity.status(400).body(dataResponse);
            }
        }
    }

    public ResponseEntity<DataResponse<String>> deleteFood(long id){
        Food oldFood = findById(id);
        if (oldFood == null) {
            DataResponse<String> dataResponse = DataResponse
                    .<String>builder()
                    .message("Food not found with id: " + id)
                    .status(404)
                    .build();
            return ResponseEntity.status(404).body(dataResponse);
        } else {
            try {
                foodRepository.delete(oldFood);
                DataResponse<String> dataResponse = DataResponse
                        .<String>builder()
                        .message("Delete food successful")
                        .data("Deleted food with id: " + id)
                        .status(200)
                        .build();
                return ResponseEntity.status(200).body(dataResponse);
            } catch (Exception e) {
                logger.error(e.getMessage());
                DataResponse<String> dataResponse = DataResponse
                        .<String>builder()
                        .message("Delete food failed: " + e.getMessage())
                        .status(400)
                        .build();
                return ResponseEntity.status(400).body(dataResponse);
            }
        }

    }

    public Food convertFoodDTOToFood(FoodDTO foodDTO){
        return Food.builder()
                .foodName(foodDTO.getFoodName())
                .price(foodDTO.getPrice())
                .description(foodDTO.getDescription())
                .build();
    }
}
