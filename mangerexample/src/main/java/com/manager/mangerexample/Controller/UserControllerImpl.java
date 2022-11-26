package com.manager.mangerexample.Controller;

import com.manager.mangerexample.Entidades.Usuario;
import com.manager.mangerexample.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/user")
public class UserControllerImpl implements UserController {
    @Autowired
    private UserService userService;
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/all")
    public ResponseEntity<List<Usuario>> getAllUsuarios(){
        List<Usuario> users= StreamSupport.stream(userService.findAll().spliterator(),false).collect(Collectors.toList());
        return  new ResponseEntity<>(users, HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping ("/find/{id}")
        public ResponseEntity<?> getUserById(@PathVariable("id") Long id){
        Optional<Usuario> oUser = userService.findById(id);
        if (!oUser.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(oUser);
        }
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/add")
    public ResponseEntity<Usuario> addUser(@RequestBody Usuario user){
        Usuario newuser= userService.save(user);
        return new ResponseEntity<>(newuser,HttpStatus.CREATED);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/update")
    public ResponseEntity<Usuario> updateUser(@RequestBody Usuario usuario) {
        Usuario updateUsuario = userService.updateUsuario(usuario);
        return new ResponseEntity<>(updateUsuario, HttpStatus.OK);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Usuario> deleteUsuario(@PathVariable("id") Long id){
        userService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
