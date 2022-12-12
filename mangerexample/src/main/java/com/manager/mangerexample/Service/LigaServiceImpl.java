package com.manager.mangerexample.Service;

import com.manager.mangerexample.Entidades.Equipo;
import com.manager.mangerexample.Entidades.Liga;
import com.manager.mangerexample.Repository.EquipoRepo;
import com.manager.mangerexample.Repository.LigaRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class LigaServiceImpl implements LigaService {
    private LigaRepo ligaRepo;
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
        Optional<Equipo> nuevoEquipo=equipoRepo.findById(idEquipo);
        if(nuevoEquipo.isPresent()){
            List<Equipo> misEquipos=liga.getListaEquipos();
            misEquipos.add(nuevoEquipo.get());
            liga.setListaEquipos(misEquipos);
            ligaRepo.save(liga);
        }

    }

    @Override
    public void crearPartidos(Liga liga) {
        Date inicio=liga.getInicio();
        Date fin=liga.getFin();
        int jornadas=liga.getJornadas();
        int misEquipos=liga.getListaEquipos().size();

        try {
            if(misEquipos%2==0){
                for(int x=0;x<=jornadas;x++){


                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
