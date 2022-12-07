package com.manager.mangerexample.Repository;

import com.manager.mangerexample.Entidades.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepo extends JpaRepository<Roles, Long> {
}
