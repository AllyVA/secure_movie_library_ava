package com.telerikacademy.web.securemovielibrary.helpers;

import com.telerikacademy.web.securemovielibrary.models.Movie;
import com.telerikacademy.web.securemovielibrary.models.dtos.CreateMovieDto;
import com.telerikacademy.web.securemovielibrary.models.dtos.MovieResponseDto;
import com.telerikacademy.web.securemovielibrary.models.dtos.UpdateMovieDto;
import com.telerikacademy.web.securemovielibrary.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MovieMapper {

    private final MovieService movieService;

    @Autowired
    public MovieMapper(MovieService movieService) {
        this.movieService = movieService;
    }

    public Movie fromDto(CreateMovieDto dto) {
        Movie movie = new Movie();

        movie.setMovieTitle(dto.getMovieTitle());
        movie.setMovieDirector(dto.getMovieDirector());
        movie.setMovieReleaseYear(dto.getMovieReleaseYear());

        return movie;
    }

    public Movie fromDto(int id, UpdateMovieDto dto) {
        Movie movie = movieService.get(id);

        if (dto.getMovieTitle() != null) {
            movie.setMovieTitle(dto.getMovieTitle());
        }

        if (dto.getMovieDirector() != null) {
            movie.setMovieDirector(dto.getMovieDirector());
        }

        if (dto.getMovieReleaseYear() != null) {
            movie.setMovieReleaseYear(dto.getMovieReleaseYear());
        }

        return movie;
    }

    public MovieResponseDto toDto(Movie movie) {
        MovieResponseDto dto = new MovieResponseDto();

        dto.setId(movie.getId());
        dto.setMovieTitle(movie.getMovieTitle());
        dto.setMovieDirector(movie.getMovieDirector());
        dto.setMovieReleaseYear(movie.getMovieReleaseYear());
        dto.setMovieRating(movie.getMovieRating());

        return dto;
    }

    public List<MovieResponseDto> toDto(List<Movie> movies) {
        List<MovieResponseDto> movieDto = new ArrayList<>();

        for (Movie movie : movies) {
            movieDto.add(toDto(movie));
        }

        return movieDto;
    }

}
