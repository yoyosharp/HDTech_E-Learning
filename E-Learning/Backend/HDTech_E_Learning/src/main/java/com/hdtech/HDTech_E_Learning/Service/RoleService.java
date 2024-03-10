package com.hdtech.HDTech_E_Learning.Service;

import com.hdtech.HDTech_E_Learning.Entity.Role;
import com.hdtech.HDTech_E_Learning.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.processing.RoundEnvironment;
import java.util.List;
import java.util.Optional;

@Service
public class RoleService implements RecordService<Role> {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role add(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public List<Role> addAll(List<Role> roles) {
        return roleRepository.saveAll(roles);
    }

    @Override
    public Optional<Role> findById(long id) {
        return roleRepository.findById(id);
    }

    @Override
    public Page<Role> findByNameContaining(String keyword, Pageable pageable) {
        return null;
    }

    @Override
    public List<Role> findAll() {
        return null;
    }
}
