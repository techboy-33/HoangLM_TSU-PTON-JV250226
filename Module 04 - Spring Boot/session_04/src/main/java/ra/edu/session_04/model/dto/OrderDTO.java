package ra.edu.session_04.model.dto;

import ra.edu.session_04.model.constant.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OrderDTO {
    private String customerName;
    private String phoneNumber;
    private String address;

}
