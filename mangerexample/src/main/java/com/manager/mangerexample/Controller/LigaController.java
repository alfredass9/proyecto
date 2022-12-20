package com.manager.mangerexample.Controller;

import com.manager.mangerexample.DTO.LigaDTO;
import com.manager.mangerexample.Entidades.Liga;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface LigaController {
    public ResponseEntity<List<Liga>> getAllLigas();
    public ResponseEntity<?> getLigaById(@PathVariable("idLiga") Long idLiga);
    public ResponseEntity<Liga> addLiga(@RequestBody LigaDTO LigaDTO);
    public ResponseEntity<Liga> updateLiga(@RequestBody Liga Liga);
    public ResponseEntity<Liga> añadirEquipo(@PathVariable String nombreLiga,@PathVariable Long userId);
    public ResponseEntity<?> creaJornadas(@RequestBody Long ligaID);
    public ResponseEntity<Liga> deleteLiga(@PathVariable("id") Long id);
    public ResponseEntity<Liga> sumarPuntos( @PathVariable("nombreLiga") String nombreLiga,@PathVariable("equipoId") Long equipoId,@PathVariable("resultado") String resultado);
}
