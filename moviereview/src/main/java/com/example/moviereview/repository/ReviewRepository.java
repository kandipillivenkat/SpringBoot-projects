package com.example.moviereview.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.moviereview.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByMovieId(Long movieId);
}
