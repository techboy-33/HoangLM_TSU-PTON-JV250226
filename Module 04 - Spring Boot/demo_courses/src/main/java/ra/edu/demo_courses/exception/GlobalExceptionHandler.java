package ra.edu.demo_courses.exception;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ra.edu.demo_courses.dto.DataResponse;


import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<DataResponse<Object>> handleNotFoundException(NotFoundException ex){
        return new ResponseEntity<>(DataResponse.builder()
                .success(false)
                .message(ex.getMessage())
                .data(null)
                .errors("NOT_FOUND")
                .timestamp(LocalDateTime.now())
                .build(), HttpStatus.NOT_FOUND);
    }
}
