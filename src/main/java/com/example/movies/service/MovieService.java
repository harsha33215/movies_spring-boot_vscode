package com.example.movies.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.movies.model.Movie;
import com.example.movies.repository.MovieJpaRepository;
import com.example.movies.repository.MovieRepository;

@Service
public class MovieService implements MovieRepository {

    @Autowired
    private MovieJpaRepository movieJpaRepository;

    @Override
    public ArrayList<Movie> getAllMovies() {
        List<Movie> moviesList = movieJpaRepository.findAll();
        ArrayList<Movie> movies = new ArrayList<>(moviesList);
        return movies;
    }

    @Override
    public Movie getMovieById(int movieId) {
        try {
            Movie movie = movieJpaRepository.findById(movieId).get();
            return movie;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Movie addMovie(Movie movie) {
        try {
            return movieJpaRepository.save(movie);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Movie updateMovie(int movieId, Movie movie) {
        try {
            Movie newMovie = movieJpaRepository.findById(movieId).get();
            if (movie.getMovieName() != null) {
                newMovie.setMovieName(movie.getMovieName());
            }
            if (movie.getLeadActor() != null) {
                newMovie.setLeadActor(movie.getLeadActor());
            }
            movieJpaRepository.save(newMovie);
            return newMovie;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteMovie(int movieId) {
        try {
            movieJpaRepository.deleteById(movieId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie is removed from database");
        }
    }

}
