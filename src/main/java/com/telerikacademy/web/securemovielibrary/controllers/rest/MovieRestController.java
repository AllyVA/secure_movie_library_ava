package com.telerikacademy.web.securemovielibrary.controllers.rest;

import com.telerikacademy.web.securemovielibrary.helpers.MovieMapper;
import com.telerikacademy.web.securemovielibrary.models.Movie;
import com.telerikacademy.web.securemovielibrary.models.dtos.CreateMovieDto;
import com.telerikacademy.web.securemovielibrary.models.dtos.MovieResponseDto;
import com.telerikacademy.web.securemovielibrary.models.dtos.UpdateMovieDto;
import com.telerikacademy.web.securemovielibrary.services.MovieService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieRestController {

    private final MovieService movieService;
    private final MovieMapper movieMapper;

    @Autowired
    public MovieRestController(MovieService movieService, MovieMapper movieMapper) {
        this.movieService = movieService;
        this.movieMapper = movieMapper;
    }

    @GetMapping
    public List<MovieResponseDto> get() {
        List<Movie> movies = movieService.get();

        return movieMapper.toDto(movies);
    }

    @GetMapping("/{id}")
    public MovieResponseDto get(@PathVariable int id) {
        Movie movie = movieService.get(id);

        return movieMapper.toDto(movie);
    }

    @GetMapping(("/search"))
    public List<MovieResponseDto> search(@RequestParam String keyword) {
        List<Movie> movies = movieService.search(keyword);

        return movieMapper.toDto(movies);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MovieResponseDto create(@RequestBody @Valid CreateMovieDto createMovieDto) {
        Movie movie = movieMapper.fromDto(createMovieDto);
        movieService.create(movie);

        return movieMapper.toDto(movie);
    }

    @PatchMapping("/{id}")
    public MovieResponseDto update(@PathVariable int id,
                                   @Valid @RequestBody UpdateMovieDto updateMovieDto) {
        Movie movie = movieMapper.fromDto(id, updateMovieDto);
        movieService.update(movie);

        return movieMapper.toDto(movie);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        movieService.delete(id);
    }
}
