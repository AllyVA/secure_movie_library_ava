package com.telerikacademy.web.securemovielibrary.repositories;

import com.telerikacademy.web.securemovielibrary.models.Movie;

import java.util.List;

public interface MovieRepository {
    List<Movie> get();

    Movie get(int id);

    void create(Movie movie);

    void update(Movie movie);

    void delete(int id);
}
