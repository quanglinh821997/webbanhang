package com.microtech.service;

import com.microtech.model.Role;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface RoleService {
    List<Role> getAllRole();
    Optional<Role> findRoleById(int id);
}
