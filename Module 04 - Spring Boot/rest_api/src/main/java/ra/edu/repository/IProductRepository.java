package ra.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.edu.model.entity.Product;
@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
}
