package com.sci_all.demo.service.impl;

import com.sci_all.demo.persistance.entities.Role;
import com.sci_all.demo.persistance.repositories.RoleRepository;
import com.sci_all.demo.service.IRoleService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private RoleRepository repository;

    @Override
    public Role findRoleByName(String name) {
        return repository.findByName(name).orElseThrow(EntityNotFoundException::new);
    }
}
