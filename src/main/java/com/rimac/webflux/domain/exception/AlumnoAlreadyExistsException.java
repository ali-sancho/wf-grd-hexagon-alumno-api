package com.rimac.webflux.domain.exception;

public class AlumnoAlreadyExistsException extends RuntimeException {

    public AlumnoAlreadyExistsException(Long id) {
        super("El alumno con id " + id + " ya existe.");
    }

}
