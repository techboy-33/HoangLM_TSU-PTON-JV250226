package com.example.session06.service;
import com.example.session06.model.dto.ReviewDTO;
import com.example.session06.model.entity.Review;
import com.example.session06.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private MovieService movieService;

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public List<Review> getReviewsByMovieId(Long movieId) {
        return reviewRepository.findByMovieId(movieId);
    }

    public Review addReview(ReviewDTO reviewDTO) {
        Review review = Review
                .builder()
                .movie(movieService.getMovieById(reviewDTO.getMovieId()))
                .comment(reviewDTO.getComment())
                .rating(reviewDTO.getRating())
                .username(reviewDTO.getUsername())
                .build();
        try {
            return reviewRepository.save(review);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public boolean deleteReview(Long id) {
        Review review = reviewRepository.findById(id).orElse(null);
        if (review != null) {
           try {
               reviewRepository.delete(review);
               return true;
           }catch (Exception e) {
               return false;
           }
        }else {
            return false;
        }
    }
}
