package com.manager.mangerexample.Service;

import com.manager.mangerexample.Entidades.Jornada;
import com.manager.mangerexample.Repository.JornadaRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JornadaServiceImpl implements JornadaService {
    private final JornadaRepo jornadaRepo;

    public JornadaServiceImpl(JornadaRepo jornadaRepo) {
        this.jornadaRepo = jornadaRepo;
    }

    @Override
    public Iterable<Jornada> findAll() {
        return jornadaRepo.findAll();
    }

    @Override
    public Page<Jornada> findAll(Pageable pageable) {
        return jornadaRepo.findAll(pageable);
    }

    @Override
    public Optional<Jornada> findById(Long id) {
        return jornadaRepo.findById(id);
    }

    @Override
    public Jornada save(Jornada jornada) {
        return jornadaRepo.save(jornada);
    }

    @Override
    public void deleteById(Long id) {
    jornadaRepo.deleteById(id);
    }
}
