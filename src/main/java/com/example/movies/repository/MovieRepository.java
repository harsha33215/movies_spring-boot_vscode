package com.example.movies.repository;

import java.util.ArrayList;

import com.example.movies.model.Movie;

public interface MovieRepository {
    ArrayList<Movie> getAllMovies();
    Movie getMovieById(int movieId);
    Movie addMovie(Movie movie);
    Movie updateMovie(int movieId, Movie movie);
    void deleteMovie(int movieId);
}