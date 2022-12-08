package com.manager.mangerexample.Controller;

import java.util.List;

import com.manager.mangerexample.Entidades.Roles;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


public interface RolController {
    public ResponseEntity<?> create(@RequestBody Roles role);

    public ResponseEntity<?> readRol(@PathVariable(value = "id") Long roleId);

    public ResponseEntity<?> rolUpdate(@RequestBody Roles rolDetails,
            @PathVariable(value = "id") Long rolId);

    public ResponseEntity<?> rolDelete(@PathVariable(value = "id") Long rolId);

    public List<Roles> readAllRoles();
}
