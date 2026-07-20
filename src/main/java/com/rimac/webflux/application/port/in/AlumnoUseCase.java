package com.rimac.webflux.application.port.in;


import com.rimac.webflux.domain.model.Alumno;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface AlumnoUseCase {


    Flux<Alumno> obtenerActivos();


    Mono<Alumno> crear(Alumno alumno);

}
