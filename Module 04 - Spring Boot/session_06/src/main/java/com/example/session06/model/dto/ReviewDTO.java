package com.example.session06.model.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ReviewDTO {
    private long movieId;
    private String username;
    private Integer rating;
    private String comment;
}
