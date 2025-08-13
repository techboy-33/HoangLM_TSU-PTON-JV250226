package ra.com.exam_webapp.repository.imp;

import org.springframework.stereotype.Repository;
import ra.com.exam_webapp.model.Food;
import ra.com.exam_webapp.repository.FoodRepository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class FoodRepositoryImp implements FoodRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Food> findAll() {
        List<Food> listFood = entityManager.createQuery("from Food", Food.class).getResultList();
        return listFood;
    }

    @Override
    public Food findById(int foodId) {
        return entityManager.createQuery("from Food where foodId = :id", Food.class).setParameter("id", foodId).getSingleResult();
    }

    @Override
    @Transactional
    public boolean create(Food food) {
        try {
            entityManager.persist(food);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public boolean update(Food food) {
        try {
            entityManager.merge(food);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public boolean delete(int foodId) {
        try {
            Food food = findById(foodId);
            entityManager.remove(food);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
