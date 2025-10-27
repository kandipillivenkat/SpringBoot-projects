package com.example.moviereview.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.example.moviereview.model.Movie;
import com.example.moviereview.model.Review;
import com.example.moviereview.repository.MovieRepository;
import com.example.moviereview.repository.ReviewRepository;



@Service
public class ReviewService {
    private final ReviewRepository reviewRepo;
    private final MovieRepository movieRepo;
    public ReviewService(ReviewRepository reviewRepo, MovieRepository movieRepo) {
        this.reviewRepo = reviewRepo;
        this.movieRepo = movieRepo;
    }
        public Review addReview(Long movieId, Review review) {
        Movie movie = movieRepo.findById(movieId).orElseThrow(() -> new NoSuchElementException("Movie not found"));
        review.setMovie(movie);
        Review saved = reviewRepo.save(review);
        // keep bidirectional list in sync
        movie.getReviews().add(saved);
        movieRepo.save(movie);
        return saved;
    }
    public List<Review> getByMovie(Long movieId) {
        return reviewRepo.findByMovieId(movieId);
    }
        public void delete(Long reviewId) {
        reviewRepo.deleteById(reviewId);
    }
}