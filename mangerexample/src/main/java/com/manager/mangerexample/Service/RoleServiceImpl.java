package com.manager.mangerexample.Service;

import com.manager.mangerexample.Entidades.Roles;
import com.manager.mangerexample.Enums.RolNombre;
import com.manager.mangerexample.Repository.RolRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Service
@Transactional
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RolRepo rolRepository;

    @Override
    @Transactional(readOnly = true)
    public Iterable<Roles> findAll() {

        return rolRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Roles> findAll(Pageable pageable) {

        return rolRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Roles> findById(Long id) {

        return rolRepository.findById(id);
    }

    @Override
    public Roles save(Roles role) {

        return rolRepository.save(role);
    }

    @Override
    public void deleteById(Long id) {

        rolRepository.deleteById(id);
    }
    public Optional<Roles> getByRolNombre(RolNombre rolNombre){
      return   rolRepository.findByRolNombre(rolNombre);
    }
}
