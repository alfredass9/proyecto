package com.manager.mangerexample.Controller;

import com.manager.mangerexample.DTO.EquipoDTO;
import com.manager.mangerexample.DTO.Mensaje;
import com.manager.mangerexample.Entidades.Equipo;
import com.manager.mangerexample.Entidades.Roles;
import com.manager.mangerexample.Entidades.Usuario;
import com.manager.mangerexample.Enums.RolNombre;
import com.manager.mangerexample.Repository.EquipoRepo;
import com.manager.mangerexample.Service.EquipoService;
import com.manager.mangerexample.Service.RoleService;
import com.manager.mangerexample.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/equipos")
public class EquipoControllerImpl implements EquipoController{
    @Autowired
        private EquipoService equipoService;
     @Autowired
     private UserService userService;
     @Autowired
     private RoleService roleService;
    @Autowired
    private EquipoRepo equipoRepo;

    @Override
    @GetMapping("/lista")
    public ResponseEntity<List<Equipo>> getAllEquipos() {
        List<Equipo> equipos= StreamSupport.stream(equipoService.findAll().spliterator(),false).collect(Collectors.toList());
        return new ResponseEntity<>(equipos, HttpStatus.OK);
    }

    @Override
    @Secured("hasRol('USER')")
    @GetMapping("/detalle/{id}")
    public ResponseEntity<?> getEquipoById(@PathVariable("id") Long idEquipo) {
        if (!equipoService.existsById(idEquipo))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Equipo esteEquipo=equipoService.findByID(idEquipo).get();
        return new ResponseEntity<>(esteEquipo,HttpStatus.OK);
    }
    @Override
    @Secured("hasRol('USER')")
    @GetMapping("/detalleNombre/{nombreEquipo}")
    public ResponseEntity<?> getEquipoByNombreEquipo(@PathVariable("nombreEquipo") String nombreEquipo) {
        if (!equipoService.existsByNombreEquipo(nombreEquipo))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Equipo esteEquipo=equipoService.getByNombreEquipo(nombreEquipo).get();
        return new ResponseEntity<>(esteEquipo,HttpStatus.OK);
    }

    @Override
    @Secured("hasRole('USER')")
    @PostMapping("/crear/{id}")
    public ResponseEntity<Equipo> addEquipo(@RequestBody EquipoDTO equipoDTO, @PathVariable("id")Long userId) {
        if(!StringUtils.hasText(equipoDTO.getNombreEquipo()))
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(equipoService.existsByNombreEquipo(equipoDTO.getNombreEquipo()))
            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);

        Set<Roles> rolCapi=new HashSet<>();
        Usuario capitan=userService.findById(userId).get();
        rolCapi=capitan.getRole();
        rolCapi.add(roleService.getByRolNombre(RolNombre.ROL_CAPITAN).get());
        userService.save(capitan);
        Equipo equipo=new Equipo(equipoDTO.getNombreEquipo(), equipoDTO.getLogo());
        Set<Usuario>nuevoJugador=new HashSet<>();
        nuevoJugador.add(capitan);
        equipo.setListaJugadores(nuevoJugador);
        Equipo nuevoEquipo =equipoService.save(equipo);
        return new ResponseEntity<>(nuevoEquipo, HttpStatus.OK);
    }

    @Override
    @Secured("hasRole('CAPITAN')")
    @PutMapping("/modificar")
    public ResponseEntity<Equipo> updateEquipo(@RequestBody Equipo equipo) {
       Equipo updateEquipo=equipoService.updateEquipo(equipo);

        return new ResponseEntity<>(updateEquipo, HttpStatus.OK) ;
    }

    @Override
    @Secured("hasRole('CAPITAN')")
    @PutMapping("/nuevoUsuario/{nombreEquipo}/{id}")
    public ResponseEntity<Equipo> añadirJugador(@PathVariable("nombreEquipo") String nombreEquipo,@PathVariable("id") Long userId) {


        if(!equipoService.existsByNombreEquipo(nombreEquipo))
            return new ResponseEntity(new Mensaje("el equipono existe"), HttpStatus.BAD_REQUEST);
        Equipo equipo=equipoService.getByNombreEquipo(nombreEquipo).get();
        Usuario jugador= userService.findById(userId).get();

        if(userService.existsByNombreUsuario(jugador.getnombreUsuario())&&!equipo.getListaJugadores().contains(jugador)) {
            Set misjugadores=new HashSet<>();
            misjugadores=equipo.getListaJugadores();
            misjugadores.add(jugador);
            equipo.setListaJugadores(misjugadores);
            equipoService.añadirUsuario(equipo);
        }


        return new ResponseEntity<>(equipo,HttpStatus.OK);
    }

    @Override
    @Secured("hasRole('CAPITAN') or hasRole('ADMIN')")
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Equipo> deleteEquipo(@PathVariable("id")Long id) {
        equipoService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
