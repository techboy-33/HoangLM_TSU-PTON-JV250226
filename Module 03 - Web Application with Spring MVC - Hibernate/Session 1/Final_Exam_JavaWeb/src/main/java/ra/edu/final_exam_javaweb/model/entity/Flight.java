package ra.edu.final_exam_javaweb.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
@Table(name = "flights")

public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long flightId;

    @Column(nullable = false, length = 100)
    private String flightName;

    @Column(nullable = false, length = 255)
    private String startingPoint;

    @Column(nullable = false, length = 255)
    private String destination;

    @Column(nullable = false, length = 255)
    private java.sql.Date departureDate;

    @Column(nullable = false)
    private Integer travelTime;

    @Column(nullable = false, length = 10)
    private String timeUnit;

    @Column(nullable = false, length = 255)
    private String travelImage;

    @Column(nullable = false)
    private Byte status = 1;
}
