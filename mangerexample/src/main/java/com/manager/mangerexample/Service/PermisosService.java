package com.manager.mangerexample.Service;

import com.manager.mangerexample.Entidades.Permisos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface PermisosService {
    public Iterable<Permisos> findAll();

    public Page<Permisos> findAll(Pageable pageable);

    public Optional<Permisos> findById(Long id);

    public Permisos save(Permisos permisos);

    public void deleteById(Long id);

}
