package com.example.moviereview.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.moviereview.model.Review;
import com.example.moviereview.service.ReviewService;
@RestController
@RequestMapping("/api/movies/{movieId}/reviews")
public class ReviewController {
    private final ReviewService service;

    public ReviewController(ReviewService service){
        this.service = service;
    }
    @PostMapping
    public Review add(@PathVariable Long movieId, @RequestBody Review review) {
        if (review.getRating() < 1 || review.getRating() > 5) {
            throw new IllegalArgumentException("Rating must be 1..5");
        }
        return service.addReview(movieId, review);
    }
    @GetMapping
    public List<Review> list(@PathVariable Long movieId) {
        return service.getByMovie(movieId);
    }
    @DeleteMapping("/{reviewId}")
    public void delete(@PathVariable Long movieId, @PathVariable Long reviewId) {
        service.delete(reviewId);
    }
}
