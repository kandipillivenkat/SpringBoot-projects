package com.example.moviereview.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.moviereview.model.Movie;
import com.example.moviereview.model.Review;
import com.example.moviereview.repository.MovieRepository;

@Service
public class MovieService {
    private final MovieRepository repo;

    @Autowired
    public MovieService(MovieRepository repo) {
        this.repo = repo;
    }
    public Movie addMovie(Movie movie) {
        return repo.save(movie);
    }
    public List<Movie> getAll() {
        return repo.findAll();
    }
    
    public Optional<Movie> getById(Long id) {
        return repo.findById(id);
    }

    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    public double averageRating(Movie movie) {
        List<Review> r = movie.getReviews();
        if (r == null || r.isEmpty()) return 0.0;
        return r.stream().mapToInt(Review::getRating).average().orElse(0.0);
    }
}
