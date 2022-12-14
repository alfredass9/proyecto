package com.manager.mangerexample.Controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.manager.mangerexample.Entidades.Permisos;
import com.manager.mangerexample.Entidades.Roles;
import com.manager.mangerexample.Service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/api/rol")
public class RolControllerImpl implements RolController {
    @Autowired
    private RoleService rolService;


    // Create a new role
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Roles role) {
        return ResponseEntity.status(HttpStatus.CREATED).body(rolService.save(role));
    }

    // read a rol
    @GetMapping("/{id}")
    public ResponseEntity<?> readRol(@PathVariable(value = "id") Long roleId) {
        Optional<Roles> oRole = rolService.findById(roleId);
        if (!oRole.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(oRole);
    }

    // Update an Role
    @PutMapping("/{id}")

    public ResponseEntity<?> rolUpdate(@RequestBody Roles rolDetails,
            @PathVariable(value = "id") Long rolId) {
        Optional<Roles> rol = rolService.findById(rolId);

        if (!rol.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        rol.get().setRolNombre(rolDetails.getRolNombre());

        return ResponseEntity.status(HttpStatus.CREATED).body(rolService.save(rol.get()));

    }
    //delete rol
    @DeleteMapping("/{id}")
    public ResponseEntity<?> rolDelete(@PathVariable(value = "id") Long rolId) {

        if (!rolService.findById(rolId).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        rolService.deleteById(rolId);
        return ResponseEntity.ok().build();
    }


    // Read all roles
    @GetMapping("/roles")
    public List<Roles> readAllRoles() {
        List<Roles> roles = StreamSupport.stream(rolService.findAll().spliterator(), false)
                .collect(Collectors.toList());

        return roles;

    }



}
