package com.manager.mangerexample.Service;

import com.manager.mangerexample.Entidades.Jornada;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface JornadaService {
    public Iterable<Jornada> findAll();

    public Page<Jornada> findAll(Pageable pageable);

    public Optional<Jornada> findById(Long id);

    public Jornada save(Jornada jornada);

    public void deleteById(Long id);
}
