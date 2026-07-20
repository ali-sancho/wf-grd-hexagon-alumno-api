package com.rimac.webflux.adapter.out.persistence;

import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.stereotype.Component;

import com.rimac.webflux.application.port.out.AlumnoRepositoryPort;
import com.rimac.webflux.domain.model.Alumno;
import com.rimac.webflux.domain.model.Estado;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class AlumnoPersistenceAdapter implements AlumnoRepositoryPort {

    private final R2dbcEntityTemplate template;
    private final AlumnoRepository repository;

    public AlumnoPersistenceAdapter(AlumnoRepository repository,
                                    R2dbcEntityTemplate template){
        this.repository = repository;
        this.template = template;
    }

    @Override
    public Mono<Boolean> existe(Long id){
        return repository.existsById(id);
    }

    @Override
    public Mono<Alumno> guardar(Alumno alumno){
        AlumnoEntity entity = new AlumnoEntity();

        entity.setId(alumno.getId());
        entity.setNombre(alumno.getNombre());
        entity.setApellido(alumno.getApellido());
        entity.setEdad(alumno.getEdad());
        entity.setEstado(
             alumno.getEstado().name()
        );

        return template.insert(AlumnoEntity.class)
            .using(entity)
            .map(e ->
                new Alumno(
                    e.getId(),
                    e.getNombre(),
                    e.getApellido(),
                    Estado.valueOf(e.getEstado()),
                    e.getEdad()
                )
            );
    }

    @Override
    public Flux<Alumno> buscarPorEstado(Estado estado){
        return repository
          .findByEstado(estado.name())
          .map(e ->
             new Alumno(
                e.getId(),
                e.getNombre(),
                e.getApellido(),
                Estado.valueOf(e.getEstado()),
                e.getEdad()
             )
          );

    }

}
