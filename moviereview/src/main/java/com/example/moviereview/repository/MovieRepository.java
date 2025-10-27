package com.example.moviereview.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.moviereview.model.Movie;



public interface MovieRepository extends JpaRepository<Movie, Long> {
    
}
