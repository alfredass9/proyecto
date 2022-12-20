package com.manager.mangerexample.Service;

import com.manager.mangerexample.Entidades.Equipo;
import com.manager.mangerexample.Entidades.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface EquipoService {
    public Iterable<Equipo> findAll();
    public Page<Equipo> findAll(Pageable pageable);
    public Optional<Equipo> findByID(Long id);
    public Equipo save(Equipo equipo);
    public  Equipo crearEquipo (Equipo equipo,Long userId);


    public void deleteById(Long id);
    public  Equipo updateEquipo(Equipo equipo);
    public void  añadirUsuario(Equipo equipo);

    public Optional<Equipo> getByNombreEquipo(String nombreEquipo);
    public boolean existsByNombreEquipo(String nombreEquipo);
    public boolean existsById(Long id);

}
