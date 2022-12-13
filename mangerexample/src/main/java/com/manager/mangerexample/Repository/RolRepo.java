package com.manager.mangerexample.Repository;

import com.manager.mangerexample.Entidades.Roles;
import com.manager.mangerexample.Enums.RolNombre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolRepo extends JpaRepository<Roles, Long> {
    Optional<Roles> findByRolNombre(RolNombre rolNombre);
}
