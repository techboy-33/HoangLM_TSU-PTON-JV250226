package ra.edu.session_04.repository;

import ra.edu.session_04.model.entity.ProductCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCartRepository extends JpaRepository<ProductCart, Long> {
    public ProductCart findProductCartByProductId(long productId);
}
