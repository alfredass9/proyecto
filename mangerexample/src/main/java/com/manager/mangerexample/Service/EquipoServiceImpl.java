package com.manager.mangerexample.Service;

import com.manager.mangerexample.Entidades.Equipo;
import com.manager.mangerexample.Entidades.Usuario;
import com.manager.mangerexample.Repository.EquipoRepo;
import com.manager.mangerexample.Repository.UserRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EquipoServiceImpl implements EquipoService{
    public EquipoRepo equipoRepo;
    public UserRepo userRepo;
    @Override
    public Iterable<Equipo> findAll() {
        return equipoRepo.findAll();
    }

    @Override
    public Page<Equipo> findAll(Pageable pageable) {
        return equipoRepo.findAll(pageable);
    }

    @Override
    public Optional<Equipo> findByID(Long id) {
        return equipoRepo.findById(id);
    }

    @Override
    public Equipo save(Equipo equipo) {
        return equipoRepo.save(equipo);
    }

    @Override
    public void deleteById(Long id) {
        equipoRepo.deleteById(id);
    }

    @Override
    public Equipo updateEquipo(Equipo equipo) {
        return equipoRepo.save(equipo);
    }

    @Override
    public void añadirUsuarioById(Long idUsuario, Equipo equipo) {
        Optional<Usuario> jugador= userRepo.findUserById(idUsuario);
        if(jugador.isPresent()) {
            List<Usuario> misjugadores = equipo.getListaJugadores();
            misjugadores.add(jugador.get());
            equipo.setListaJugadores(misjugadores);
            equipoRepo.save(equipo);
        }
    }


}
