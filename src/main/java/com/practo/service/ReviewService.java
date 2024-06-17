package com.practo.service;

import org.springframework.stereotype.Service;

import com.practo.entity.Review;
import com.practo.exception.InvalidRatingException;
import com.practo.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public Review addReview(Review review) {
        validateRating(review.getRating());
        Review savedReview = reviewRepository.save(review);
        updateAverageRating(review.getDoctorId());
        return savedReview;
    }
    public List<Review> findReviewsByDoctorId(Long doctorId) {
        return reviewRepository.findByDoctorId(doctorId);
    }

    private void validateRating(Integer rating) {
        if (rating < 1 || rating > 5) {
            throw new InvalidRatingException("Rating must be between 1 and 5.");
        }
    }

    private void updateAverageRating(Long doctorId) {
        List<Review> reviews = reviewRepository.findByDoctorId(doctorId);
        double averageRating = reviews.stream()
                .mapToInt(Review::getRating)
                .average()
                .orElse(0.0);
    }
}

