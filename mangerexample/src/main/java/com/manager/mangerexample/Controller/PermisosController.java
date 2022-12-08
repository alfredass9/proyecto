package com.manager.mangerexample.Controller;

import java.util.List;

import com.manager.mangerexample.Entidades.Permisos;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;



public interface PermisosController {
    public ResponseEntity<?> create(@RequestBody Permisos permiso);

    public ResponseEntity<?> readPermisos(@PathVariable(value = "id") Long PermisosId);

    public ResponseEntity<?> PermisosUpdate(@RequestBody Permisos permisosDetails,
            @PathVariable(value = "id") Long PermisosId);

    public ResponseEntity<?> PermisosDelete(@PathVariable(value = "id") Long PermisosId);

    public List<Permisos> readAllPermisos();
}
