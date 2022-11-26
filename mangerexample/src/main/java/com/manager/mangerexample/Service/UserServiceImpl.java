package com.manager.mangerexample.Service;


import com.manager.mangerexample.Entidades.Usuario;
import com.manager.mangerexample.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private final UserRepo useRepo;

    public UserServiceImpl(UserRepo useRepo) {
        this.useRepo = useRepo;
    }

    @Override
    public Iterable<Usuario> findAll() {
        return useRepo.findAll();
    }

    @Override
    public Page<Usuario> findAll(Pageable pageable) {
        return useRepo.findAll(pageable);
    }

    @Override
    public Optional<Usuario> findById(Long id) {
        return useRepo.findUserById(id);
    }

    @Override
    public Usuario save(Usuario usuario) {
        usuario.setCodigoUsuario(UUID.randomUUID().toString());
        return  useRepo.save(usuario);
    }

    public Usuario updateUsuario(Usuario usuario) {
        return useRepo.save(usuario);
    }

    @Override
    public void deleteById(Long id) {
        useRepo.deleteById(id);
    }
}
