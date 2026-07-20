package com.rimac.webflux.adapter.in.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.rimac.webflux.domain.exception.AlumnoAlreadyExistsException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AlumnoAlreadyExistsException.class)
    public ProblemDetail handleAlumnoExists(AlumnoAlreadyExistsException ex) {

        ProblemDetail problem = ProblemDetail.forStatus(HttpStatus.CONFLICT);
        problem.setTitle("Alumno ya existe");
        problem.setDetail(ex.getMessage());
        return problem;
    }
}
