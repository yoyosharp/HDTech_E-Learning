package com.hdtech.HDTech_E_Learning.Service;

import com.hdtech.HDTech_E_Learning.Entity.Role;

import javax.annotation.processing.RoundEnvironment;
import java.util.Optional;

public interface RoleService {
    Role addRole(Role role);

    Optional<Role> findById(long id);

    Optional<Role> findByName(String name);
}
