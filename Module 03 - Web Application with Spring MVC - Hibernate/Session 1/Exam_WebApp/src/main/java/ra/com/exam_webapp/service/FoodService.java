package ra.com.exam_webapp.service;

import ra.com.exam_webapp.model.Food;

import java.util.List;

public interface FoodService {
    List<Food> findAll();
    Food findById(int id);
    boolean create(Food food);
    boolean update(Food food);
    boolean delete(int foodId);
}
