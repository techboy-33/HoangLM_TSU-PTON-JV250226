package ra.com.exam_webapp.service.imp;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.com.exam_webapp.model.Food;
import ra.com.exam_webapp.repository.FoodRepository;
import ra.com.exam_webapp.service.FoodService;

import java.util.List;
@Service
public class FoodServiceImp implements FoodService {
    private static final Log log = LogFactory.getLog(FoodServiceImp.class);
    @Autowired
    private FoodRepository foodRepository;

    @Override
    public List<Food> findAll() {
        return foodRepository.findAll();
    }

    @Override
    public Food findById(int id) {
        return foodRepository.findById(id);
    }


    @Override
    public boolean create(Food food) {
        return foodRepository.create(food);
    }

    @Override
    public boolean update(Food food) {
        return foodRepository.update(food);
    }

    @Override
    public boolean delete(int foodId) {
        return foodRepository.delete(foodId);
    }
}
