package com.telerikacademy.web.securemovielibrary.exceptions;

public class InvalidMovieDataException extends RuntimeException {
    public InvalidMovieDataException(String message) {
        super(message);
    }
}
