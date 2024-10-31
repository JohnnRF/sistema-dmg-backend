package com.dmg.sistema_dmg_backend.auth.service;

import com.dmg.sistema_dmg_backend.auth.persitence.entity.UserEntity;
import com.dmg.sistema_dmg_backend.auth.persitence.repository.UserRepository;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Secured("ROLE_admin")
    public List<UserEntity> getAll(){
        List<UserEntity> users = (List<UserEntity>) this.userRepository.findAll();
        return users;
    }
}
