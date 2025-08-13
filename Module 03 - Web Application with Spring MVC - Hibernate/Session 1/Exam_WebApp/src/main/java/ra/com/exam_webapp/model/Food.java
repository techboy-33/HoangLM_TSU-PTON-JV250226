package ra.com.exam_webapp.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Food")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "food_id")
    private int foodId;
    @Column(name = "food_name", columnDefinition = "varchar(200)", nullable = false, unique = true)
    private String foodName;
    @Column (name = "ingredients", columnDefinition = "text",nullable = false)
    private String ingredients;
    @Column (name = "instructions", columnDefinition = "text",nullable = false)
    private String instructions;
    @Column (name = "prep_time", nullable = false)
    private int prepTime;
    @Column (name = "cook_time", nullable = false)
    private int cookTime;
    @Column (name = "image_path", columnDefinition = "text",nullable = false)
    private String imagePath;
    @Column (name = "status", columnDefinition = "bit default(1)")
    private boolean status;




}
