package com.dmg.sistema_dmg_backend.auth.service;

import com.dmg.sistema_dmg_backend.auth.persitence.entity.RoleEntity;
import com.dmg.sistema_dmg_backend.auth.persitence.entity.UserEntity;
import com.dmg.sistema_dmg_backend.auth.persitence.repository.RoleRepository;
import com.dmg.sistema_dmg_backend.auth.persitence.repository.UserRepository;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;


    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    @Secured("ROLE_admin")
    public List<UserEntity> getAll(){
        List<UserEntity> users = (List<UserEntity>) this.userRepository.findAll();
        return users;
    }

    public UserEntity createUser (UserEntity user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return this.userRepository.save(user);
    }

    public UserEntity assignRoles(long userId, List<Long> rolesIds) {
        UserEntity user = this.userRepository.findById(userId).orElseThrow( ()-> new UsernameNotFoundException("User not found"));

        Set<RoleEntity> roles = new HashSet<>(this.roleRepository.findAllById(rolesIds));

        user.setRoles(roles);

        return this.userRepository.save(user);
    }
}
