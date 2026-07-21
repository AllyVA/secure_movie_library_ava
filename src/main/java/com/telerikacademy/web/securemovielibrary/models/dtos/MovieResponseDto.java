package com.telerikacademy.web.securemovielibrary.models.dtos;

public class MovieResponseDto {

    private int id;
    private String movieTitle;
    private String movieDirector;
    private Integer movieReleaseYear;
    private Double movieRating;

    public MovieResponseDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Double getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(Double movieRating) {
        this.movieRating = movieRating;
    }
}
