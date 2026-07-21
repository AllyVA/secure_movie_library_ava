package com.telerikacademy.web.securemovielibrary.models.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateMovieDto {

    @NotBlank
    @Size(max = 200)
    private String movieTitle;

    @Size(max = 150)
    private String movieDirector;

    @Min(1888)
    @Max(2100)
    private Integer movieReleaseYear;

    public CreateMovieDto() {
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getMovieDirector() {
        return movieDirector;
    }

    public void setMovieDirector(String movieDirector) {
        this.movieDirector = movieDirector;
    }

    public Integer getMovieReleaseYear() {
        return movieReleaseYear;
    }

    public void setMovieReleaseYear(Integer movieReleaseYear) {
        this.movieReleaseYear = movieReleaseYear;
    }
}
