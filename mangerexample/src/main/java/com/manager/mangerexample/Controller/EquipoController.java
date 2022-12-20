package com.manager.mangerexample.Controller;

import com.manager.mangerexample.DTO.EquipoDTO;
import com.manager.mangerexample.Entidades.Equipo;
import com.manager.mangerexample.Entidades.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface EquipoController {
    public ResponseEntity<List<Equipo>> getAllEquipos();
    public ResponseEntity<?> getEquipoById(@PathVariable("idEquipo") Long idEquipo);
    public ResponseEntity<Equipo> addEquipo(@RequestBody EquipoDTO equipoDTO, Long userId);
    public ResponseEntity<Equipo> updateEquipo(@RequestBody Equipo equipo);
    public ResponseEntity<Equipo> añadirJugador(@PathVariable String nombreEquipo,@PathVariable Long userId);
    public ResponseEntity<Equipo> deleteEquipo(@PathVariable("id") Long id);
    public ResponseEntity<?> getEquipoByNombreEquipo(@PathVariable("nombreEquipo") String nombreEquipo);
}
