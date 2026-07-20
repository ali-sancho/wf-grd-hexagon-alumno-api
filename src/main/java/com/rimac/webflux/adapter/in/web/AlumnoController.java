package com.rimac.webflux.adapter.in.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rimac.webflux.application.port.in.AlumnoUseCase;
import com.rimac.webflux.domain.model.Alumno;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {

    private final AlumnoUseCase useCase;

    public AlumnoController(AlumnoUseCase useCase){
        this.useCase = useCase;
    }

    @GetMapping("/activos")
    public Flux<Alumno> activos(){
        return useCase.obtenerActivos();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Void> crear(@RequestBody Alumno alumno){
        return useCase.crear(alumno).then();
    }

}
