package ra.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.edu.model.entity.Category;
@Repository
public interface ICategoryRepository extends JpaRepository<Category, String> {
}
