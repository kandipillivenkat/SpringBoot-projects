package com.example.moviereview.controller;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.moviereview.model.Movie;
import com.example.moviereview.service.MovieService;

@RestController
@RequestMapping("/api/movies")
public class MovieController {
    private final MovieService service;

    public MovieController(MovieService service) {
        this.service = service;
    }
    @PostMapping
    public Movie addMovie(@RequestBody Movie movie) {
        return service.addMovie(movie);
    }
    @GetMapping
    public List<Movie> getAll() {
        return service.getAll();
    }
    @GetMapping("/{id}/rating")
    public Map<String, Object> getAvgRating(@PathVariable Long id) {
        Movie m = service.getById(id).orElseThrow(() -> new NoSuchElementException("Movie not found"));
        double avg = service.averageRating(m);
        return Map.of("movieId", id, "averageRating", avg);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }
    //new change
}
