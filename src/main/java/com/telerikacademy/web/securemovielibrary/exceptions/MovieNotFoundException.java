package com.telerikacademy.web.securemovielibrary.exceptions;

public class MovieNotFoundException extends RuntimeException {
    public MovieNotFoundException(String type) {
        super(String.format("%s not found.", type));
    }
}
