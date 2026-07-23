package com.telerikacademy.web.securemovielibrary.services;

import com.telerikacademy.web.securemovielibrary.exceptions.InvalidMovieDataException;
import com.telerikacademy.web.securemovielibrary.exceptions.MovieNotFoundException;
import com.telerikacademy.web.securemovielibrary.models.Movie;
import com.telerikacademy.web.securemovielibrary.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }


    @Override
    public List<Movie> get() {
        return movieRepository.get();
    }

    @Override
    public Movie get(int id) {
        Movie movie = movieRepository.get(id);

        if (movie == null) {
            throw new MovieNotFoundException("Movie");
        }

        return movie;
    }

    @Override
    public List<Movie> search(String title) {
        if (title == null || title.isBlank()) {
            throw new InvalidMovieDataException(
                    "Search keyword cannot be empty."
            );
        }

        return movieRepository.search(title.trim());
    }

    @Override
    public void create(Movie movie) {
        movieRepository.create(movie);
    }

    @Override
    public void update(Movie movie) {
        Movie existing = get(movie.getId());

        boolean hasChanges = false;

        if (movie.getMovieTitle() != null) {
            existing.setMovieTitle(movie.getMovieTitle());
            hasChanges = true;
        }

        if (movie.getMovieDirector() != null) {
            existing.setMovieDirector(movie.getMovieDirector());
            hasChanges = true;
        }

        if (movie.getMovieReleaseYear() != null) {
            existing.setMovieReleaseYear(movie.getMovieReleaseYear());
            hasChanges = true;
        }

        if (!hasChanges) {
            throw new InvalidMovieDataException(
                    "At least one movie field must be provided for update."
            );
        }

        movieRepository.update(existing);
    }

    @Override
    public void delete(int id) {
        movieRepository.get(id);
        movieRepository.delete(id);
    }
}
