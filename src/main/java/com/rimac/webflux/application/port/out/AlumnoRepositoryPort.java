package com.rimac.webflux.application.port.out;


import com.rimac.webflux.domain.model.Alumno;
import com.rimac.webflux.domain.model.Estado;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface AlumnoRepositoryPort {


    Mono<Boolean> existe(Long id);


    Mono<Alumno> guardar(Alumno alumno);


    Flux<Alumno> buscarPorEstado(Estado estado);

}
