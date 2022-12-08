package com.manager.mangerexample.Repository;

import com.manager.mangerexample.Entidades.Partidos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartidoRepo extends JpaRepository<Partidos,Long> {
}
