package ra.edu.tsu_ptonnjjv250226_leminhhoang.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "inventory_management")
public class InventoryManagement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventory_id")
    private Integer inventoryId;

    @Column(name = "material_name", nullable = false, length = 100)
    private String materialName;

    @Column(name = "producer", nullable = false, length = 100)
    private String producer;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "price_unit", nullable = false, length = 50)
    private String priceUnit;

    @Column(name = "image_url", length = 255)
    private String imageUrl;

    @Column(name = "note", length = 255)
    private String note;

    @Column(name = "status", columnDefinition = "BIT DEFAULT 1")
    private Boolean status;
}
