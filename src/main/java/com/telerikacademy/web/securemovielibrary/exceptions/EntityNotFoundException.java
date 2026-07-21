package com.telerikacademy.web.securemovielibrary.exceptions;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String type) {
        super(String.format("%s not found.", type));
    }
}
