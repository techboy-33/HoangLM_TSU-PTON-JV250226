package ra.edu.tsu_ptonnjjv250226_leminhhoang.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class APIResponse<T, E> {
    private boolean success;
    private String message;
    private T data;
    private E error;
    private int httpStatus;
}
