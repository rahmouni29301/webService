package com.esprit.microservice.offre.controllers;

import com.esprit.microservice.offre.entity.Review;
import com.esprit.microservice.offre.serviceImpl.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    // Create a new review
    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Review review) {
        Review savedReview = reviewService.save(review);
        return new ResponseEntity<>(savedReview, HttpStatus.CREATED);
    }

    // Get a specific review by ID
    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long id) {
        Optional<Review> review = reviewService.findById(id);
        return review.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Get all reviews
    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews() {
        List<Review> reviews = reviewService.findAll();
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    // Update an existing review
    @PutMapping("/{id}")
    public ResponseEntity<Review> updateReview(@PathVariable Long id, @RequestBody Review reviewDetails) {
        Optional<Review> reviewOptional = reviewService.findById(id);
        if (reviewOptional.isPresent()) {
            Review reviewToUpdate = reviewOptional.get();
            reviewToUpdate.setComment(reviewDetails.getComment());
            reviewToUpdate.setRatings(reviewDetails.getRatings());
            Review updatedReview = reviewService.save(reviewToUpdate);
            return new ResponseEntity<>(updatedReview, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a review by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long id) {
        if (reviewService.existsById(id)) {
            reviewService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
