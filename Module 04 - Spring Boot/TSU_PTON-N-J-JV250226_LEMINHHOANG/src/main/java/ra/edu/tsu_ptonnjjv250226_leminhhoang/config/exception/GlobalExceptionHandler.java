package ra.edu.tsu_ptonnjjv250226_leminhhoang.config.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ra.edu.tsu_ptonnjjv250226_leminhhoang.dto.response.APIResponse;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
//    Xử lí không được để trống
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<APIResponse<Object,Object>> handleValidateException(MethodArgumentNotValidException e) {
        Map<String, String> errors = new HashMap<>();

        e.getFieldErrors().forEach(err->{
            errors.put(err.getField(), err.getDefaultMessage());
        });
        APIResponse<Object,Object> response = new APIResponse<>();
        response.setSuccess(false);
        response.setMessage("Thao tác thất bại");
        response.setError(errors);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST); // 400
    }

//    Xử lí trùng
    @ExceptionHandler(ConflictDataException.class)
    public ResponseEntity<APIResponse<Object,Object>> handleConflictDataException(ConflictDataException e) {

        APIResponse<Object,Object> response = new APIResponse<>();
        response.setSuccess(false);
        response.setMessage("Thao tác thất bại");
        response.setError("Lỗi : "+e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.CONFLICT); // 409
    }
}
