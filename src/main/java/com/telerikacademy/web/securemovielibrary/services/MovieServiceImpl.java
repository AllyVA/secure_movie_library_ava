package com.telerikacademy.web.securemovielibrary.services;

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
        return movieRepository.get(id);
    }

    @Override
    public List<Movie> search(String title) {
        return movieRepository.search(title);
    }

    @Override
    public void create(Movie movie) {
        movieRepository.create(movie);
    }

    @Override
    public void update(Movie movie) {
        movieRepository.update(movie);
    }

    @Override
    public void delete(int id) {
        movieRepository.delete(id);
    }
}
