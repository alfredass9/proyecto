package com.manager.mangerexample.Service;

import com.manager.mangerexample.Entidades.Equipo;
import com.manager.mangerexample.Entidades.Liga;
import com.manager.mangerexample.Repository.EquipoRepo;
import com.manager.mangerexample.Repository.LigaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class LigaServiceImpl implements LigaService {
   @Autowired
   private LigaRepo ligaRepo;
   @Autowired
    private EquipoRepo equipoRepo;

    @Override
    public Iterable<Liga> findAll() {
        return ligaRepo.findAll();
    }

    @Override
    public Page<Liga> findAll(Pageable pageable) {
        return ligaRepo.findAll(pageable);
    }

    @Override
    public Optional<Liga> findById(Long id) {

        return ligaRepo.findById(id);

    }

    @Override
    public Liga save(Liga liga) {
        return ligaRepo.save(liga);
    }

    @Override
    public void deleteById(Long id) {
        ligaRepo.deleteById(id);
    }

    @Override
    public Liga updateLiga(Liga liga) {
        return ligaRepo.save(liga);
    }

    @Override
    public void añadirEquipo(Long idEquipo, Liga liga) {

        ligaRepo.save(liga);
    }

    public boolean existsByNombreLiga(String nombreLiga) {
        return ligaRepo.existsByNombreLiga(nombreLiga);
    }

    @Override
    public Optional<Liga> findBynombreLiga(String nombreLiga) {
        return ligaRepo.findByNombreLiga(nombreLiga);
    }

    @Override
    public boolean existsById(Long id) {
        return ligaRepo.existsById(id);
    }

}

