package com.telerikacademy.web.securemovielibrary.services;

import com.telerikacademy.web.securemovielibrary.models.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> get();

    Movie get(int id);

    List<Movie> search(String title);

    void create(Movie movie);

    void update(Movie movie);

    void delete(int id);
}
