package com.example.demo.exceptions;

public class UsuarioNotFoundException extends RuntimeException {

    public UsuarioNotFoundException(Long id) {
        super("Could not find usuario " + id);
    }

}
