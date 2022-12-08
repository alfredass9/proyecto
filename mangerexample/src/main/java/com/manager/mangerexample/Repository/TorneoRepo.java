package com.manager.mangerexample.Repository;

import com.manager.mangerexample.Entidades.Torneo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TorneoRepo extends JpaRepository<Torneo, Long> {
}
