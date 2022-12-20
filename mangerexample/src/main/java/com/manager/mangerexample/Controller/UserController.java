package com.manager.mangerexample.Controller;

import com.manager.mangerexample.Entidades.Usuario;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
public interface UserController {
    public ResponseEntity<List<Usuario>> getAllUsuarios();
    public ResponseEntity<?> getUserNombreUsuario(@PathVariable("nombreUsuario") String nombreUsuario);
    public ResponseEntity<Usuario> addUser(@RequestBody Usuario user);
    public ResponseEntity<Usuario> updateUser(@RequestBody Usuario userdetails);
    public ResponseEntity<Usuario> deleteUsuario(@PathVariable("id") Long id);
}
