package ra.edu.demo_courses.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Long courseId;
    @NotBlank
    private String title;
    private String description;

//    @Column(name = "teacher_id")
//    private Long teacherId;
    @DecimalMin(value = "1.0", message = "Price must be at least 1")
    @DecimalMax(value = "1000000000.0", message = "Price must be at most 1 billion")
    private BigDecimal price;

    @Column(name = "duration_hours")
    private Integer durationHours;

    private Status status;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public enum Status {
        DRAFT, PUBLISHED, ARCHIVED
    }
}
