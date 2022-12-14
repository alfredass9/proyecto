package com.manager.mangerexample.Controller;

import com.manager.mangerexample.DTO.*;
import com.manager.mangerexample.Entidades.Roles;
import com.manager.mangerexample.Entidades.Usuario;
import com.manager.mangerexample.Enums.RolNombre;
import com.manager.mangerexample.Jwt.JwtProvider;
import com.manager.mangerexample.Service.RoleService;
import com.manager.mangerexample.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.manager.mangerexample.DTO.Mensaje;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;
    @Autowired
    JwtProvider jwtProvider;
    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuarioDTO nuevoUsuarioDTO, BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("Campos mal puestos o mail invalido"), HttpStatus.BAD_REQUEST);
        if (userService.existsByNombreUsuario(nuevoUsuarioDTO.getNombreUsuario()))
            return new ResponseEntity(new Mensaje("Nombre Usuario ya existe"), HttpStatus.BAD_REQUEST);
        if (userService.existsByEmail(nuevoUsuarioDTO.getEmail()))
            return new ResponseEntity(new Mensaje("Ese email ya existe"), HttpStatus.BAD_REQUEST);
        Usuario usuario = new Usuario(nuevoUsuarioDTO.getName(),nuevoUsuarioDTO.getNombreUsuario(),nuevoUsuarioDTO.getPosicion(),
                nuevoUsuarioDTO.getEmail(), passwordEncoder.encode(nuevoUsuarioDTO.getPassword()),
                nuevoUsuarioDTO.getImageUrl());
        Set<Roles> roles= new HashSet<>();
        roles.add(roleService.getByRolNombre(RolNombre.ROLE_USER).get());
        if(nuevoUsuarioDTO.getRoles().contains("admin"))
            roles.add(roleService.getByRolNombre(RolNombre.ROLE_ADMIN).get());
        usuario.setRole(roles);
        userService.save(usuario);

        return new ResponseEntity<>(new Mensaje("usuario guardado"), HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<JwtDTO> login(@Valid@RequestBody LoginUsuarioDTO loginUsuarioDTO,BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("Campos mal puestos"), HttpStatus.BAD_REQUEST);
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuarioDTO.getNombreUsuario(), loginUsuarioDTO.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        JwtDTO jwtDTO = new JwtDTO(jwt, userDetails.getUsername(),userDetails.getAuthorities());
        return new ResponseEntity<>(jwtDTO,HttpStatus.OK);
    }
}
