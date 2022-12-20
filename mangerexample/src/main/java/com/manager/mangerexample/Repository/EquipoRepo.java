package com.manager.mangerexample.Repository;

import com.manager.mangerexample.Entidades.Equipo;
import com.manager.mangerexample.Entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EquipoRepo extends JpaRepository<Equipo, Long> {
    Optional<Equipo> findByNombreEquipo(String nombreEquipo);
    boolean existsByNombreEquipo(String nombreEquipo);

}
