package com.rimac.webflux.application.service;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.rimac.webflux.application.port.out.AlumnoRepositoryPort;
import com.rimac.webflux.domain.model.Alumno;
import com.rimac.webflux.domain.model.Estado;

import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

/**
 * AlumnoServiceTest
 */
 @ExtendWith(MockitoExtension.class)
public class AlumnoServiceTest {
  @Mock
  private AlumnoRepositoryPort repository;

  @InjectMocks
  private AlumnoService service;

 @Test
 void shouldCreateAlumno() {

    Alumno alumno = new Alumno(
            1L,
            "Juan",
            "Perez",
            Estado.ACTIVO,
            20
    );

    when(repository.existe(1L)).thenReturn(Mono.just(false));
    when(repository.guardar(alumno)).thenReturn(Mono.just(alumno));
    StepVerifier.create(service.crear(alumno))
            .expectNext(alumno)
            .verifyComplete();

    verify(repository).existe(1L);
    verify(repository).guardar(alumno);

}   
}
