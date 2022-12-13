package com.manager.mangerexample.Service;

import com.manager.mangerexample.Entidades.Permisos;
import com.manager.mangerexample.Repository.PermisosRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class PermisosServiceImpl implements PermisosService {
    private PermisosRepo permisoRepo;
    @Override
    public Iterable<Permisos> findAll() {
        return permisoRepo.findAll();
    }

    @Override
    public Page<Permisos> findAll(Pageable pageable) {
        return permisoRepo.findAll(pageable);
    }

    @Override
    public Optional<Permisos> findById(Long id) {
        return permisoRepo.findById(id);
    }

    @Override
    public Permisos save(Permisos permiso) {
        return permisoRepo.save(permiso );
    }

    @Override
    public void deleteById(Long id) {
        permisoRepo.deleteById(id);

    }
}
