package com.example.session06.model.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ShowtimeDTO {
    private long movieId;
    private long screenRoomId;
    @JsonFormat(shape = JsonFormat.Shape.STRING , pattern = "dd/MM/yyyy HH:mm:ss")
//    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime showtime;
}
