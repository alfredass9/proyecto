package com.manager.mangerexample.Repository;

import com.manager.mangerexample.Entidades.Equipo;
import com.manager.mangerexample.Entidades.Liga;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LigaRepo extends JpaRepository<Liga,Long> {
    Optional<Liga> findByNombreLiga(String nombreLiga);
    boolean existsByNombreLiga(String nombreLiga);
}
