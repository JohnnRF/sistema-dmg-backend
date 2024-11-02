package com.dmg.sistema_dmg_backend.auth.service;

import com.dmg.sistema_dmg_backend.auth.persitence.entity.RoleEntity;
import com.dmg.sistema_dmg_backend.auth.persitence.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class RoleService {
    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Optional<RoleEntity> findById(Long id){
        return this.roleRepository.findById(id);
    }

    public Set<RoleEntity> findRolesByIds(List<Long> roleIds){
        Set<RoleEntity> roles = new HashSet<>();

        for (Long id: roleIds){
            Optional<RoleEntity> role = this.roleRepository.findById(id);
            role.ifPresent(roles::add);
        }

        return roles;
    }
}
