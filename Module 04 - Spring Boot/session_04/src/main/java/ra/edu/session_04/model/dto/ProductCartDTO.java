package ra.edu.session_04.model.dto;

import ra.edu.session_04.model.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductCartDTO {
    private Long productId;
    private int quantity;
}
