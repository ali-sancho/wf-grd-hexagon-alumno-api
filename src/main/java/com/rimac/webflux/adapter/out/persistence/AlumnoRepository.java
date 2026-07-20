package com.rimac.webflux.adapter.out.persistence;


import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import reactor.core.publisher.Flux;


public interface AlumnoRepository 
extends ReactiveCrudRepository<AlumnoEntity,Long>{

    Flux<AlumnoEntity> findByEstado(String estado);

}
