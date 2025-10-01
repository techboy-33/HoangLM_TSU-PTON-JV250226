package ra.edu.session_04.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class ProductExercise01 {
    private long id ;
    private String name ;
    private double price ;
}
