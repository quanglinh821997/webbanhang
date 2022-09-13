package com.microtech.service.impl;

import com.microtech.model.Role;
import com.microtech.repository.RoleRepo;
import com.microtech.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class RoleServiceImpl implements RoleService {

    @Autowired private RoleRepo roleRepo;

    @Override
    public List<Role> getAllRole() {
        return roleRepo.findAll();
    }

    @Override
    public Optional<Role> findRoleById(int id) {
        return roleRepo.findById(id);
    }
}
