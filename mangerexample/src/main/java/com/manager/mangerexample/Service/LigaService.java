package com.manager.mangerexample.Service;

import com.manager.mangerexample.Entidades.Equipo;
import com.manager.mangerexample.Entidades.Liga;
import com.manager.mangerexample.Entidades.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface LigaService {
    public  Iterable<Liga> findAll();
    public Page<Liga> findAll(Pageable pageable);

    public Optional<Liga> findById(Long id);

    public Liga save(Liga liga);

    public void deleteById(Long id);
    public Liga updateLiga(Liga Liga);
    public void  añadirEquipo(Long idEquipo, Liga liga);
    public void crearPartidos(Liga liga);
}
