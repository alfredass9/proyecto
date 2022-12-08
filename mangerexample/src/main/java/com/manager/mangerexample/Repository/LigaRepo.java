package com.manager.mangerexample.Repository;

import com.manager.mangerexample.Entidades.Partidos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LigaRepo extends JpaRepository<Partidos,Long> {
}
