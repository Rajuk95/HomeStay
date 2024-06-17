package com.practo.controller;



import com.practo.entity.Review;
import com.practo.exception.InvalidRatingException;
import com.practo.payload.ReviewDto;
import com.practo.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<?> addReview(@RequestBody ReviewDto reviewDTO) {
        try {
            Review review = new Review();
            review.setDoctorId(reviewDTO.getDoctorId());
            review.setPatientId(reviewDTO.getPatientId());
            review.setRating(reviewDTO.getRating());

            Review savedReview = reviewService.addReview(review);
            return ResponseEntity.ok(savedReview);
        } catch (InvalidRatingException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<List<Review>> getReviewsByDoctorId(@PathVariable Long doctorId) {
        List<Review> reviews = reviewService.findReviewsByDoctorId(doctorId);
        return ResponseEntity.ok(reviews);
    }
}

