package com.manager.mangerexample.Service;

import com.manager.mangerexample.Entidades.Equipo;
import com.manager.mangerexample.Repository.EquipoRepo;
import com.manager.mangerexample.Repository.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipoServiceImpl implements EquipoService{
    @Autowired
    public EquipoRepo equipoRepo;
    @Autowired
    public UserRepo userRepo;
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserService userService;
    private final  static Logger logger= LoggerFactory.getLogger(Equipo.class);
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
    public Equipo crearEquipo(Equipo equipo, Long userId) {
        return null;
    }

    @Override
    public Equipo save(Equipo equipo) {

        return  equipoRepo.save(equipo);
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
    public void añadirUsuario(Equipo equipo) {
                    equipoRepo.save(equipo);
    }

    @Override
    public Optional<Equipo> getByNombreEquipo(String nombreEquipo) {
        return equipoRepo.findByNombreEquipo(nombreEquipo);
    }

    @Override
    public boolean existsByNombreEquipo(String nombreEquipo) {
        return equipoRepo.existsByNombreEquipo(nombreEquipo);
    }
    public boolean existsById(Long id){
        return equipoRepo.existsById(id);
    }


}
