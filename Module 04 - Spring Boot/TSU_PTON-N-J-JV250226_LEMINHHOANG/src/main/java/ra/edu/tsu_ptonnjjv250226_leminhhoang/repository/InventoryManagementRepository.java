package ra.edu.tsu_ptonnjjv250226_leminhhoang.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ra.edu.tsu_ptonnjjv250226_leminhhoang.entity.InventoryManagement;

public interface InventoryManagementRepository extends JpaRepository<InventoryManagement, Integer> {
    boolean existsByMaterialName(String materialName);

    @Query("SELECT CASE WHEN COUNT(i) > 0 THEN true ELSE false END FROM InventoryManagement i WHERE i.materialName = :materialName AND i.inventoryId <> :id")
    boolean existsByMaterialNameForUpdate(@Param("materialName") String materialName, @Param("id") Integer id);

    Page<InventoryManagement> findAllByMaterialNameContaining(String materialName, Pageable pageable);

    Page<InventoryManagement> findAllByProducerContainingAndQuantityGreaterThanEqual(String producer, Integer quantityIsGreaterThan, Pageable pageable);
}
