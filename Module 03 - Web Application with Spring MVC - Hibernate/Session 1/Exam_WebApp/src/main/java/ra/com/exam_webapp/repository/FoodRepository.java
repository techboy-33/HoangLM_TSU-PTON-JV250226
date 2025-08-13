package ra.com.exam_webapp.repository;

import ra.com.exam_webapp.model.Food;

import java.util.List;

public interface FoodRepository {
    List<Food> findAll();

    Food findById(int foodId);

    boolean create(Food food);

    boolean update(Food food);

    boolean delete(int foodId);
}
