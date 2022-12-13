package com.manager.mangerexample.Service;


import com.manager.mangerexample.Entidades.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Optional;

public interface UserService {
    public  Iterable<Usuario> findAll();
    public Page<Usuario> findAll(Pageable pageable);

    public Optional<Usuario> findById(Long id);

    public Usuario save(Usuario usuario);

    public void deleteById(Long id);
    public Usuario updateUsuario(Usuario usuario);
    public Optional<Usuario> getByNombreUsuario(String nombreUsuario);
    public boolean existsByNombreUsuario(String nombreUsuario);
    public boolean existsByEmail(String email);
}
