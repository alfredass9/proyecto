package com.manager.mangerexample.Service;

import com.manager.mangerexample.Entidades.Partidos;
import com.manager.mangerexample.Repository.PartidoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PartidoServiceImpl implements PartidosService{

    @Autowired
    private PartidoRepo partidoRepo;



    @Override
    public Partidos crearPartido(Partidos partidos) {
        return partidoRepo.save(partidos);
    }

    @Override
    public Page<Partidos> findAll(Pageable pageable) {
        return partidoRepo.findAll(pageable);
    }

    @Override
    public Partidos save(Partidos partidos) {
        return partidoRepo.save(partidos);
    }

    @Override
    public void deleteById(Long id) {
    partidoRepo.deleteById(id);
    }
}
