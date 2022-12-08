package com.manager.mangerexample.Repository;

import com.manager.mangerexample.Entidades.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipoRepo extends JpaRepository<Equipo, Long> {
}
