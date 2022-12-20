package com.manager.mangerexample.Service;

import com.manager.mangerexample.Entidades.Roles;
import com.manager.mangerexample.Enums.RolNombre;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface RoleService {
    public Iterable<Roles> findAll();
    public Optional<Roles> getByRolNombre(RolNombre rolNombre);

    public Page<Roles> findAll(Pageable pageable);

    public Optional<Roles> findById(Long id);

    public Roles save(Roles role);

    public void deleteById(Long id);
}
