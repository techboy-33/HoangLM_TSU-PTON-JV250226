package com.example.session06.controller;

import com.example.session06.model.dto.ReviewDTO;
import com.example.session06.model.entity.Review;
import com.example.session06.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews() {
        return new ResponseEntity<>(reviewService.getAllReviews(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addReview(@RequestBody ReviewDTO reviewDTO) {
        Review review = reviewService.addReview(reviewDTO);
        if (review == null) {
            return new ResponseEntity<>("add review failed", HttpStatus.BAD_REQUEST);
        }else {
            return new ResponseEntity<>(review, HttpStatus.CREATED);
        }
    }

    @GetMapping("/findAllByMovieId/{id}")
    public ResponseEntity<List<Review>> findAllByMovieId(@PathVariable Long id) {
        return new ResponseEntity<>(reviewService.getReviewsByMovieId(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteReview(@PathVariable Long id) {
       boolean rs = reviewService.deleteReview(id);
       if (rs){
           return new ResponseEntity<>("delete review successful", HttpStatus.OK);
       }else {
           return new ResponseEntity<>("delete review failed", HttpStatus.BAD_REQUEST);
       }
    }
}
