package ra.edu.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ra.edu.model.dto.DataResponse;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice // để đánh dấu là lớp xử lý ngoại lệ toàn cục
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<DataResponse<Object>> handleNotFoundException(NotFoundException ex){
        return new ResponseEntity<>(DataResponse.builder()
                .success(false)
                .message(ex.getMessage())
                .data(null)
                .error("NOT_FOUND")
                .timestamp(LocalDateTime.now())
                .build(),  HttpStatus.NOT_FOUND);
    }

//    hibernate exception


    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<DataResponse<Object>> handleRuntimeException(RuntimeException ex){
        return new ResponseEntity<>(DataResponse.builder()
                .success(false)
                .message(ex.getMessage())
                .data(null)
                .error("INTERNAL_SERVER_ERROR")
                .timestamp(LocalDateTime.now())
                .build(),  HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
