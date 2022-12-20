package com.manager.mangerexample.Service;

import com.manager.mangerexample.Entidades.Partidos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PartidosService {
    Partidos crearPartido(Partidos partidos);
    Page<Partidos> findAll(Pageable pageable);
    public Partidos save(Partidos partidos);
    public void deleteById(Long id);
}
