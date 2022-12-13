package com.manager.mangerexample.Controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.manager.mangerexample.Entidades.Permisos;
import com.manager.mangerexample.Service.PermisosService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/permisos")
public class PermisosControllerImpl implements PermisosController{
    private PermisosService permisoService;


    // Create a new role
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Permisos permiso) {

        return ResponseEntity.status(HttpStatus.CREATED).body(permisoService.save(permiso));
    }

    // read a rol
    @GetMapping("{id}")
    public ResponseEntity<?> readPermisos(@PathVariable(value = "id") Long permisolegioId) {
        Optional<Permisos> opermisolegio = permisoService.findById(permisolegioId);
        if (!opermisolegio.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(opermisolegio);
    }

    // Update an User
    @PutMapping("{id}")

    public ResponseEntity<?> PermisosUpdate(@RequestBody Permisos permisolegioDetails,
            @PathVariable(value = "id") Long permisolegioId) {
        Optional<Permisos> permiso = permisoService.findById(permisolegioId);

        if (!permiso.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        permiso.get().setName(permisolegioDetails.getName());

        return ResponseEntity.status(HttpStatus.CREATED).body(permisoService.save(permiso.get()));

    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> PermisosDelete(@PathVariable(value = "id") Long permisoId) {

        if (!permisoService.findById(permisoId).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        permisoService.deleteById(permisoId);

        return ResponseEntity.ok().build();
    }

    // Read all roles
    @GetMapping("/Permisos")
    public List<Permisos> readAllPermisos() {
        List<Permisos> roles = StreamSupport.stream(permisoService.findAll().spliterator(), false)
                .collect(Collectors.toList());
        return roles;

    }

}
