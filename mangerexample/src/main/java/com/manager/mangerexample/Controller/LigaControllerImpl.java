package com.manager.mangerexample.Controller;

import com.manager.mangerexample.DTO.LigaDTO;
import com.manager.mangerexample.DTO.Mensaje;
import com.manager.mangerexample.Entidades.Equipo;
import com.manager.mangerexample.Entidades.Jornada;
import com.manager.mangerexample.Entidades.Liga;
import com.manager.mangerexample.Entidades.Partidos;
import com.manager.mangerexample.Jwt.JwtTokenFilter;
import com.manager.mangerexample.Repository.JornadaRepo;
import com.manager.mangerexample.Repository.LigaRepo;
import com.manager.mangerexample.Service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/ligas")
public class LigaControllerImpl implements LigaController {
    @Autowired
    private EquipoService equipoService;
    @Autowired
    private LigaService ligaService;
   @Autowired
   private PartidosService partidosService;
    @Autowired
    private JornadaService jornadaService;
    @Autowired
    private JornadaRepo jornadaRepo;
    private final  static Logger logger= LoggerFactory.getLogger(JwtTokenFilter.class);

    @Override
    @GetMapping("/lista")
    public ResponseEntity<List<Liga>> getAllLigas() {
        List<Liga> misLigas= StreamSupport.stream(ligaService.findAll().spliterator(),false).collect(Collectors.toList());
        return new ResponseEntity<>(misLigas, HttpStatus.OK);
    }

   @Override
    @Secured("hasRol('USER')")
    @GetMapping("/detalle/{id}")
    public ResponseEntity<?> getLigaById(@PathVariable("id") Long idLiga) {
       if (!ligaService.existsById(idLiga))
           return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
       Liga liga=ligaService.findById(idLiga).get();
        return new ResponseEntity<>(liga,HttpStatus.OK);
    }

    @Override
    @Secured("hasRole('USER')")
    @PostMapping("/crear")
    public ResponseEntity<Liga> addLiga(@RequestBody LigaDTO ligaDTO) {
        if(!StringUtils.hasText(ligaDTO.getNombreLiga()))
            return new ResponseEntity(new Mensaje(ligaDTO.getNombreLiga()), HttpStatus.BAD_REQUEST);
        if(!StringUtils.hasText(ligaDTO.getDireccion()))
            return new ResponseEntity(new Mensaje(ligaDTO.getDireccion()), HttpStatus.BAD_REQUEST);
        if(ligaService.existsByNombreLiga(ligaDTO.getNombreLiga()))
            return new ResponseEntity(new Mensaje("ese Liga ya existe"), HttpStatus.BAD_REQUEST);
            Liga nuevaLiga= new Liga(ligaDTO.getNombreLiga(), ligaDTO.getDireccion(),ligaDTO.getLogo());
            ligaService.save(nuevaLiga);
            return  new ResponseEntity<>(nuevaLiga,HttpStatus.OK);
    }

    @Override
    @Secured("hasRole('CAPITAN')")
    @PutMapping("/modificar")
    public ResponseEntity<Liga> updateLiga(Liga liga) {
        ligaService.updateLiga(liga);
        return new ResponseEntity<>(liga,HttpStatus.OK);
    }

    @Override
    @Secured("hasRole('CAPITAN')")
    @PutMapping("/nuevoEquipo/{nombreLiga}/{id}")
    public ResponseEntity<Liga> añadirEquipo( @PathVariable("nombreLiga") String nombreLiga, @PathVariable("id") Long equipoId) {
        Optional<Equipo> nuevoEquipo=equipoService.findByID(equipoId);
        if(nuevoEquipo.isPresent()&&ligaService.existsByNombreLiga(nombreLiga)){
            Liga liga=ligaService.findBynombreLiga(nombreLiga).get();
            List<Equipo> misEquipos=liga.getListaEquipos();
            misEquipos.add(nuevoEquipo.get());
            liga.setListaEquipos(misEquipos);
            ligaService.save(liga);
        }
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
    @Override
    @Secured("hasRole('CAPITAN')")
    @PutMapping("/sumarPuntos/{nombreLiga}/{equipoid}/{resultado}")
    public ResponseEntity<Liga> sumarPuntos( @PathVariable("nombreLiga") String nombreLiga, @PathVariable("equipoid") Long equipoId,@PathVariable("resultado") String resultado) {
        Optional<Equipo> nuevoEquipo=equipoService.findByID(equipoId);
        if(nuevoEquipo.isPresent()&&ligaService.existsByNombreLiga(nombreLiga)&&resultado=="victoria"){
           Equipo equipo= equipoService.findByID(equipoId).get();
           int mispuntos=equipo.getMisPuntos()+3;
            equipo.setMisPuntos(mispuntos);
            equipoService.updateEquipo(equipo);
        } if(nuevoEquipo.isPresent()&&ligaService.existsByNombreLiga(nombreLiga)&&resultado=="empate"){
            Equipo equipo= equipoService.findByID(equipoId).get();
            int mispuntos=equipo.getMisPuntos()+1;
            equipo.setMisPuntos(mispuntos);
            equipoService.updateEquipo(equipo);
        }
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @Override
    @Secured("hasRole('CAPITAN')")
    @PutMapping("/crearJornadas/{id}")
    public ResponseEntity<?> creaJornadas(@PathVariable("id") Long ligaID) {
        if(!ligaService.existsById(ligaID)){
            return new ResponseEntity(new Mensaje("ese Liga no existe"), HttpStatus.BAD_REQUEST);}

        Liga miLiga=ligaService.findById(ligaID).get();
        List<Jornada> rounds = new ArrayList<>();
        List<Equipo> teams=miLiga.getListaEquipos();
        // Ensure that the teams list is not empty
        if (teams.isEmpty()&& teams.size()>1) {
          return new ResponseEntity(new Mensaje("no Hay equipos o hay muy pocos"), HttpStatus.BAD_REQUEST);
        }

        // Create a list of teams to use in the schedule
        List<Equipo> teamList = new ArrayList<>(teams);

        // Add a "bye" team to the list if there are an odd number of teams
        if (teams.size() % 2 != 0) {
            teamList.add(new Equipo());
        }

        // Determine the number of rounds to play
        int numRounds = teamList.size() - 1;

        // Create the rounds
        for (int roundNumber = 1; roundNumber <= numRounds; roundNumber++) {
            Jornada round = new Jornada((long) roundNumber);
            rounds.add(round);

            // Create the matches for this round
            for (int i = 0; i < teamList.size() / 2; i++) {
                Equipo local= teamList.get(i);
                Equipo visitante = teamList.get(teamList.size() - i - 1);

                // Create the match and add it to the round
                Partidos match = new Partidos(local, visitante);
                partidosService.save(match);
                round.getMisPartidos().add(match);

            }
            jornadaService.save(round);
            // Rotate the list of teams for the next round
            teamList.add(1, teamList.remove(teamList.size() - 1));
        }

        // Save the rounds and matches to the database
        miLiga.setListaJornadas(rounds);
        ligaService.save(miLiga);
        return new ResponseEntity<>(ligaID,HttpStatus.CREATED);
    }



    @Override
    public ResponseEntity<Liga> deleteLiga(Long id) {
        ligaService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
