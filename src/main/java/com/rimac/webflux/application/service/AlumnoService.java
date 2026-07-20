package com.rimac.webflux.application.service;

import org.springframework.stereotype.Service;

import com.rimac.webflux.application.port.in.AlumnoUseCase;
import com.rimac.webflux.application.port.out.AlumnoRepositoryPort;
import com.rimac.webflux.domain.exception.AlumnoAlreadyExistsException;
import com.rimac.webflux.domain.model.Alumno;
import com.rimac.webflux.domain.model.Estado;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AlumnoService implements AlumnoUseCase {

    private final AlumnoRepositoryPort repository;

    public AlumnoService(AlumnoRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public Flux<Alumno> obtenerActivos(){
        return repository.buscarPorEstado(
                Estado.ACTIVO
        );
    }

    @Override
    public Mono<Alumno> crear(Alumno alumno){
        return repository.existe(alumno.getId())
            .flatMap(existe -> {
                if(existe){
                    return Mono.error(
                       new AlumnoAlreadyExistsException(alumno.getId())                        
                    );
                }
                return repository.guardar(alumno);
            });
    }

}
